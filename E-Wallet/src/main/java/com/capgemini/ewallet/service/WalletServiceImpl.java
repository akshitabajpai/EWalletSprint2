
package com.capgemini.ewallet.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.dao.AccountDao;
import com.capgemini.ewallet.dao.TransactionDao;
import com.capgemini.ewallet.dao.UserDao;
import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.exception.WalletException;


@Service
@Transactional
public class WalletServiceImpl implements WalletService{
	
	@Autowired
	UserDao userdao;
	@Autowired
	AccountDao accountdao;
	@Autowired
	TransactionDao transferdao;
	

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String depositmoney(WalletAccount wallet, double amount) {

		if (amount >= 0) {
			double new_balance = wallet.getAccountBalance() + amount;			
			updateBalance(wallet.getAccountId(),new_balance);
			return "Balance added Successfully";
		}

		return "Amount cannot be negative";
	}
	
	@Override
	public WalletUser showBalance(int userId) {
		// TODO Auto-generated method stub
		WalletUser user1 = userdao.findById(userId).orElse(new WalletUser());
		
		if(user1.getUserId() == 0) {
			throw new WalletException("Account not found!");
			
		}
		else {
			System.out.println(user1.getWalleAccount().getAccountBalance());
			return user1;
		}

	}
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateBalance(int accountId, double amount) {

		WalletAccount wallet;
		Optional<WalletAccount> present = accountdao.findById(accountId);
		if (present.isPresent())
			wallet = present.get();
		else
			throw new WalletException("Account not found"); 

		wallet.setAccountBalance(amount);
	}

	@Override
	@Transactional(readOnly = true)
	public WalletAccount findAccount(int accountId) {

		Optional<WalletAccount> acc = accountdao.findById(accountId);
		if (acc.isPresent()) 
			
			return acc.get();
		else
			throw new WalletException("AccountId  not found!");
		
	}


}