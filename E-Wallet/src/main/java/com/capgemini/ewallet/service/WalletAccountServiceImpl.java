package com.capgemini.ewallet.service;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.dao.AccountDao;
import com.capgemini.ewallet.dao.TransactionDao;
import com.capgemini.ewallet.dao.UserDao;
import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.exception.EwalletException;


@Service
@Transactional
public class WalletAccountServiceImpl implements WalletAccountService{

@Autowired
UserDao userdao;
@Autowired
AccountDao accountdao;
@Autowired
TransactionDao transferdao;


@Transactional(propagation = Propagation.REQUIRED)
public String depositmoney(WalletAccount wallet, double amount) {

if (amount >= 0) {
double new_balance = wallet.getAccountBalance() + amount;
updateBalance(wallet.getAccountId(),new_balance);
return "Balance added Successfully";
}
else
return "Amount cannot be negative";
}

public WalletUser showBalance(int userId) {
// TODO Auto-generated method stub
WalletUser user1 = userdao.findById(userId).orElse(new WalletUser());

if(user1.getUserId() == 0) {
throw new EwalletException("Account not found!");

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
throw new EwalletException("Account not found");

wallet.setAccountBalance(amount);
}

@Transactional(readOnly = true)
public WalletAccount findAccount(int accountId) {

Optional<WalletAccount> acc = accountdao.findById(accountId);
if (acc.isPresent())

return acc.get();
else
throw new EwalletException("AccountId  not found!");

}

@Override
public List<WalletAccount> viewAccount() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void depositemoney(@Valid WalletAccount input) throws EwalletException {
	// TODO Auto-generated method stub
	
}


}