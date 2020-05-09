package com.capgemini.ewallet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ewallet.entity.WalletTransactions;

@Repository
public interface TransactionDao extends JpaRepository<WalletTransactions, Integer> {
	List<WalletTransactions> findBySenderId(int senderId);

}