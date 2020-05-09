package com.capgemini.ewallet.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;

import com.capgemini.ewallet.entity.WalletTransactions;
import com.capgemini.ewallet.exception.EwalletException;
import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.dao.AccountDao;
import com.capgemini.ewallet.dao.TransactionDao;

@Service
@Transactional
public  class TransactionServiceImpl implements TransactionService{

	
	@Autowired
	TransactionDao transferdao;
	
	@Autowired
	AccountDao accountdao;
	
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
	public String TransferAmount(WalletTransactions transfer) {
		// TODO Auto-generated method stub
		if(transfer.getAmount()<=0) {
			return "Enter amount to be transferred";
		}
		transferdao.save(transfer);
		

		WalletAccount sender = findAccount(transfer.getSenderId());
		WalletAccount receiver = findAccount(transfer.getReceiverId());
		double sender_new_balance = sender.getAccountBalance()-transfer.getAmount();
		double receiver_new_balance = receiver.getAccountBalance() +transfer.getAmount();
		
		updateBalance(sender.getAccountId(),sender_new_balance);
		updateBalance(receiver.getAccountId(),receiver_new_balance);
		
		return "Transaction Successfully Completed";

	}
    
    @Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBalance(int accountId, double amount) {
		// TODO Auto-generated method stub
		WalletAccount wallet;
		Optional<WalletAccount> present = accountdao.findById(accountId);
		if (present.isPresent())
			wallet = present.get();
		else
			throw new EwalletException("Account not found"); 

		wallet.setAccountBalance(amount);

	}
	
	@Override
	@Transactional(readOnly = true)
	public WalletAccount findAccount(int accountId) {
		// TODO Auto-generated method stub
		Optional<WalletAccount> acc = accountdao.findById(accountId);
		if(acc.isPresent()) 
			return acc.get();
		else
			throw new EwalletException("AccountId  not found!"); 
		
	}
	
    
	@Override
	@Transactional(readOnly = true)
	public List<WalletTransactions> transactionHistory(int senderId) {
		// TODO Auto-generated method stub
		List<WalletTransactions> history= transferdao.findBySenderId(senderId);
		System.out.println(history.get(0));
		return history;
	}
	

}
