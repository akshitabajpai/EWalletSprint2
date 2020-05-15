package com.capgemini.ewallet.service;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import java.util.List;
import java.util.Optional;

import com.capgemini.ewallet.entity.WalletTransactions;
import com.capgemini.ewallet.exception.TransactionException;
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
	public String TransferMoney(int senderId,int recieverId,double amt) throws TransactionException {
		// TODO Auto-generated method stub
    	WalletAccount SenderAccount, RecieverAccount;
		Optional<WalletAccount> SenderAccountOp=accountdao.findById(senderId);
		if(SenderAccountOp.isPresent()) {
			SenderAccount=SenderAccountOp.get();
		}
		else {
			throw new TransactionException("Sender ID is not present");
		}
		
		Optional<WalletAccount> RecieverAccountOp=accountdao.findById(recieverId);
		if(RecieverAccountOp.isPresent()) {
			RecieverAccount=RecieverAccountOp.get();
		}
		else {
			throw new TransactionException("Reciever ID is not present");
		}
		
		if(SenderAccount.getAccountBalance() < amt) throw new TransactionException("Insufficient Balance");
		SenderAccount.setAccountBalance(SenderAccount.getAccountBalance()-amt);
		RecieverAccount.setAccountBalance(RecieverAccount.getAccountBalance()+amt);
		accountdao.updateBalance(SenderAccount.getAccountBalance(), SenderAccount.getAccountId());
		accountdao.updateBalance(RecieverAccount.getAccountBalance(), RecieverAccount.getAccountId());
		
		
		


//		WalletAccount sender = findAccount(transfer.getSenderId());
//		WalletAccount receiver = findAccount(transfer.getReceiverId());
//		double sender_new_balance = sender.getAccountBalance()-transfer.getAmount();
//		double receiver_new_balance = receiver.getAccountBalance() +transfer.getAmount();
//		
//		updateBalance(sender.getAccountId(),sender_new_balance);
//		updateBalance(receiver.getAccountId(),receiver_new_balance);
//		
     	return "Transaction Successfully Completed";
}  
//    @Override
//	@Transactional(propagation = Propagation.REQUIRED)
//	public void updateBalance(int accountId, double amount) {
//		// TODO Auto-generated method stub
//		WalletAccount wallet;
//		Optional<WalletAccount> present = accountdao.findById(accountId);
//		if (present.isPresent())
//			wallet = present.get();
//		else
//			throw new TransactionException("Account not found"); 
//
//		wallet.setAccountBalance(amount);
//    }
//
//	@Override
//	@Transactional(readOnly = true)
//	public WalletAccount findAccount(int accountId) {
//		// TODO Auto-generated method stub
//		Optional<WalletAccount> acc = accountdao.findById(accountId);
//		if(acc.isPresent()) 
//			return acc.get();
//		else
//			throw new EwalletException("AccountId  not found!"); 
//		
//	}
	
    
	@Override
	@Transactional(readOnly = true)
	public List<WalletTransactions> viewAllTransactions(){
		return transferdao.findAll();
//	public List<WalletTransactions> transactionHistory(int senderId) {
//		// TODO Auto-generated method stub
//		List<WalletTransactions> history= transferdao.findBySenderId(senderId);
//		System.out.println(history.get(0));
//		return history;
	}



	

}
