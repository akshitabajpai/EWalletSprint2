package com.capgemini.ewallet.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="account")
@DynamicUpdate(true)
@DynamicInsert(true)
public class WalletAccount {
	
	@NotNull(message="AccountId is Mandatory")
	@Id
	@Column(name="acc_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="acc_seq")
	@SequenceGenerator(sequenceName="acc_seq",initialValue=2020200000,allocationSize=1,name="acc_seq")
	private int accountId;
	
	@NotNull(message="Balance is Mandatory")
	@Min(value=1000, message= "Your Opening amount must be Rs. 1000")
	private double accountBalance;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",referencedColumnName="user_id")
	private WalletUser walletUser;

	public WalletAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WalletAccount( int accountId, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public WalletUser getWalletUser() {
		return walletUser;
	}

	public void setWalletUser(WalletUser walletUser) {
		this.walletUser = walletUser;
	}

	

}
