package com.capgemini.ewallet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.capgemini.ewallet.entity.WalletTransactions;
import com.capgemini.ewallet.exception.TransactionException;
import com.capgemini.ewallet.service.TransactionServiceImpl;

@RestController
@RequestMapping("/transaction")

public class TransactionController {
	
	@Autowired 
	TransactionServiceImpl transactionService; 
	
	@CrossOrigin 
	@GetMapping(value="/history")
	public ResponseEntity<List<WalletTransactions>> getWalletTransactions() { 
		  
	List<WalletTransactions> history= transactionService.viewWalletTransactions();
		return new ResponseEntity<List<WalletTransactions>>(history,HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@PostMapping(value = "/transfer", consumes = { "application/json" })
	
//	public String transferMoney(@Valid @RequestBody WalletTransactions transfer) {
//		
//		return transactionService.TransferAmount(transfer);
//		 
//	}
	public ResponseEntity<String> transferMoney(@Valid @RequestBody WalletTransactions wt, BindingResult br) throws TransactionException
	{
		String err="";
		if(br.hasErrors()) {
			List<FieldError> errors =br.getFieldErrors();
			for(FieldError error:errors)
				err+=error.getDefaultMessage()+"<br/>";
			throw new TransactionException(err);
		}
		transactionService.TransferAmount(wt.getSenderId(), wt.getReceiverId(), wt.getAmount());
		return new ResponseEntity<String>("Ammount Transferred", HttpStatus.OK);
	}

}
