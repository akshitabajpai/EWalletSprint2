package com.capgemini.ewallet.service;

import java.util.List;

import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.entity.WalletTransactions;

public interface TransactionService {
//	public WalletAccount findAccount(int accountId);
	public String TransferAmount(int sender,int reciever,double amt);
//	public void updateBalance(int accountId, double amount);
	public List<WalletTransactions> viewWalletTransactions();

}
