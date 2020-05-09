package com.capgemini.ewallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.ewallet.entity.WalletUser;

@Repository
public interface UserDao extends JpaRepository<WalletUser,Integer>{

}
