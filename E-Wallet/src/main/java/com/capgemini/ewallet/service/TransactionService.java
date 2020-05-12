package com.capgemini.ewallet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.entity.WalletTransactions;
@Service
public interface TransactionService {
//	public WalletAccount findAccount(int accountId);
	String TransferMoney(int senderId, int recieverId, double amt);
//	public void updateBalance(int accountId, double amount);
	List<WalletTransactions> viewAllTransactions();

}
