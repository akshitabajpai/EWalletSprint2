package com.capgemini.ewallet.service;


import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.entity.WalletAccount;

public interface WalletService {
	
	
	public String depositmoney(WalletAccount wallet, double amount);
	public void updateBalance(int accId, double amount);
	public WalletAccount findAccount(int accId);
	public WalletUser showBalance(int userId);

}

