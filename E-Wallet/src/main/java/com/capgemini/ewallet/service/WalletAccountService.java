package com.capgemini.ewallet.service;


import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.exception.EwalletException;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;

import com.capgemini.ewallet.entity.WalletAccount;

public interface WalletAccountService {


public static ResponseEntity<String> depositmoney(WalletAccount wallet, double amount) throws EwalletException {
	// TODO Auto-generated method stub
	return null;
}

public void updateBalance(int accId, double amount) throws EwalletException;


public static WalletAccount findAccount(int accId) throws EwalletException {
	// TODO Auto-generated method stub
	return null;
}
public static WalletUser showBalance(int userId) throws EwalletException {
	// TODO Auto-generated method stub
	return null;
}
List<WalletAccount> viewAccount();
public void depositemoney(@Valid WalletAccount input) throws EwalletException;

}