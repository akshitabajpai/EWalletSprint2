package com.capgemini.ewallet.entity;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;


@Entity
@Table(name="transaction")
@DynamicUpdate(true)
@DynamicInsert(true)
public class WalletTransactions {
	@Id
	@NotNull(message="id is mandatory")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="trans_seq")
	@SequenceGenerator(sequenceName="trans_seq",initialValue=05000,allocationSize=1,name="trans_seq")
	@Column(name="trans_id")
	private int transactionId;
	
	@NotNull(message="should not be null")
	@Column(name="sender_id")
	private int senderId;
	
	@NotNull(message="Should not be null")
	@Column(name="receiver_id")
	private int receiverId;
	
	@NotEmpty(message="description is Mandatory")
	@Size(min=10,max=40,message="Length must of 10 to 40 characters ")
	@Column(name="description")
	private String description;
	
	@JsonDeserialize(using = DateDeserializer .class)
	 private Date dateofTransaction;
	
//	
//	@Column(name="transactiondate")
//	@JsonFormat(pattern="yyyy-mm-dd HH:mm:ss", timezone="India")
//	private LocalDateTime dateofTransaction;
	
	@NotNull(message="Amount is mandatory")
	@Min(value=1000, message="Can transfer minimum Rs. 1000")
	@Max(value=50000, message="Can transfer maximum Rs. 50000")
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
	
	
//	public LocalDateTime getDateofTransaction() {
//		return dateofTransaction;
//	}
//	public void setDateofTransaction(LocalDateTime dateofTransaction) {
//		this.dateofTransaction = dateofTransaction;
	public Date getDateofTransaction() {
		return dateofTransaction;
	}
	public void setDateofTransaction(Date dateofTransaction) {
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
			Date dateofTransaction,Double amount,Double accountBalance) {
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
