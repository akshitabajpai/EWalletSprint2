package com.capgemini.ewallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.ewallet.dao.AccountDao;
import com.capgemini.ewallet.dao.UserDao;
import com.capgemini.ewallet.entity.WalletAccount;
import com.capgemini.ewallet.entity.WalletUser;

@SpringBootApplication
public class EWalletApplication implements CommandLineRunner{
	@Autowired
	private UserDao userdao;
	private AccountDao accountdao;

	public static void main(String[] args) {
		SpringApplication.run(EWalletApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		WalletUser u1=new WalletUser(1001,"akshita bajpai","Ak@123456","9794286661","akshita");
//		userdao.save(u1);
//		WalletUser u2=new WalletUser(1002,"ankita tiwari","At@123456","9876543211","ankita");
//		userdao.save(u2);
////		WalletAccount a1=new WalletAccount(2020200001,1000);
////		accountdao.save(a1);
////		WalletAccount a2=new WalletAccount(2020200002,2000);
////		accountdao.save(a2);
//	}
	
}
