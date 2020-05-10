package com.capgemini.ewallet.entity;
import javax.persistence.*;
import java.time.LocalDateTime;



import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="transaction")
@DynamicUpdate(true)
@DynamicInsert(true)
public class WalletTransactions {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trans_seq")
	@SequenceGenerator(sequenceName="trans_seq",initialValue=05000,allocationSize=1,name="trans_seq")
	@Column(name="trans_id")
	private int transactionId;
	
	@NotNull
	@Column(name="sender_id")
	private int senderId;
	
	@NotNull
	@Column(name="receiver_id")
	private int receiverId;
	
	@NotNull(message="description is Mandatory")
	@Size(min=10,max=40,message="Length must of 10 to 40 characters ")
	@Column(name="description")
	private String description;
	
	
	@Column(name="transactiondate")
	@JsonFormat(pattern="yyyy-mm-dd HH:mm:ss", timezone="India")
	private LocalDateTime dateofTransaction;
	
	@NotNull(message="amount is mandatory")
	@Max(value=100000,message="Amount to be transferred must not be greater than 100000")
	@Column(name="amt")
	private Double amount;
	
	@NotEmpty
	@Min(value=1000)
	@Column(name="acctBal")
	private Double accountBalance;
	
	
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getDateofTransaction() {
		return dateofTransaction;
	}
	public void setDateofTransaction(LocalDateTime dateofTransaction) {
		this.dateofTransaction = dateofTransaction;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	public WalletTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WalletTransactions(int transactionId, int senderId, int receiverId, String description,
			LocalDateTime dateofTransaction,Double amount,Double accountBalance) {
		super();
		this.transactionId = transactionId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.description = description;
		this.dateofTransaction = dateofTransaction;
		this.amount = amount;
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "WalletTransactions [transactionId=" + transactionId + ", senderId=" + senderId + ", receiverId="
				+ receiverId + ", description=" + description + ", dateofTransaction=" + dateofTransaction + ", amount="
				+ amount + ", accountBalance=" + accountBalance + "]";
	}
	
	

}
