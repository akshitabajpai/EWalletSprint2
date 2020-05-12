package com.capgemini.ewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.entity.WalletTransactions;
import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.service.WalletServiceImpl;

@RestController
@RequestMapping("/wallet")
public class WalletController {


@Autowired WalletServiceImpl WalletService;



@PostMapping(value = "/depositmoney", consumes = { "application/json" })
public String depositmoney(@RequestBody WalletAccount input) {
WalletAccount wallet = WalletService.findAccount(input.getAccountId());
double amount = input.getAccountBalance();

return WalletService.depositmoney(wallet, amount);
}


@GetMapping(value = "/showBalance/{userid}")
public WalletUser showBalance(@PathVariable int userid) {
	
WalletUser user1 = WalletService.showBalance(userid);
return user1;
}

}
