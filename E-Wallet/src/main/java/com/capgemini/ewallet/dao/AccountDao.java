package com.capgemini.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.ewallet.entity.WalletAccount;


public interface AccountDao extends JpaRepository<WalletAccount,Integer>{
	@Modifying(clearAutomatically = true)
	@Query("UPDATE WalletAccount a SET a.accountBalance= :account_balance WHERE a.accountId= :accountId")
	int updateBalance(@Param("account_balance") double balance, @Param("accountId") int accountId);
	

}
