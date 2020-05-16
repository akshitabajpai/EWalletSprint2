package com.capgemini.ewallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ewallet.exception.EwalletException;
import com.capgemini.ewallet.service.WalletAccountService;
import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.entity.WalletAccount;

import com.capgemini.ewallet.service.WalletAccountServiceImpl;


@RestController
@RequestMapping("/wallet")
public class WalletAccountController {


private static final org.springframework.http.HttpStatus HttpStatus = null;
private static final org.springframework.http.HttpStatus OK = null;
@Autowired 
private WalletAccountService ser;

@GetMapping("/viewall")
public ResponseEntity<List<WalletAccount>> getAccounts(){
	List<WalletAccount> accountList= ser.viewAccount();
	return new ResponseEntity<List<WalletAccount>>(accountList,HttpStatus.OK );
}

@PostMapping(value = "/depositmoney", consumes = { "application/json" })
public ResponseEntity<String> depositmoney(@Valid @RequestBody WalletAccount input, BindingResult br) throws EwalletException
{
	String err="";
	if(br.hasErrors()) {
		List<FieldError> errors= br.getFieldErrors();
		for(FieldError error:errors)
			err +=error.getDefaultMessage() +"<br/>";
		throw new EwalletException(err);
	}
	try {
		ser.depositemoney(input);
		return new ResponseEntity<String>("Amount added", HttpStatus.OK);
		
	}
	catch(DataIntegrityViolationException ex) {
		throw new EwalletException("Amount can not be negative");
	}
}


@GetMapping(value = "/showBalance/{id}")
public WalletUser showBalance(@PathVariable int userid) {

WalletUser user1 = WalletAccountService.showBalance(userid);
return user1;
}

}