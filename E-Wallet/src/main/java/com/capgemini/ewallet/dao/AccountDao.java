package com.capgemini.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.ewallet.entity.WalletAccount;

public interface AccountDao extends JpaRepository<WalletAccount,Integer>{
	

}
