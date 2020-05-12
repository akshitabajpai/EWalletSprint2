package com.capgemini.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.capgemini.ewallet.entity.WalletAccount;


public interface AccountDao extends JpaRepository<WalletAccount,Integer>{
	@Modifying(clearAutomatically = true)
	@Query("UPDATE WalletAccount a SET a.account_balance= :account_balance WHERE a.acc_Id= :accountId")
	int updateBalance(@Param("balance") double balance, @Param("accountId") double new_balance);
	

}
