package com.capgemini.ewallet.service;


import java.util.List;
import com.capgemini.ewallet.entity.WalletUser;
import com.capgemini.ewallet.exception.WalletUserException;


public interface WalletUserService {

	boolean addAccount(WalletUser walletuser);
	List<WalletUser> getAllWalletUser();
	
	WalletUser saveUser(WalletUser user);

}
