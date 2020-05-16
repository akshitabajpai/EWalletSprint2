package com.capgemini.ewallet.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.dao.UserDao;

@Service
public  class WalletUserServiceImpl  implements WalletUserService {
	
	@Autowired
	private UserDao userdao;

	@Override
	public List<WalletUser> getAllWalletUser() {
		// TODO Auto-generated method stub
		return userdao.findAll();
	}
	
	@Override
	public WalletUser saveUser(WalletUser user) {
		return userdao.save(user);
	}

	@Override
	public boolean addAccount(WalletUser walletuser) {
	
		WalletUser accountResult= userdao.save(walletuser);
		if(accountResult!=null) {
			return true;
		}
		else
			return false;
	}
}