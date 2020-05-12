package com.capgemini.ewallet.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Transaction {
	@NotNull(message="From Account ID is mandatory")
	private Integer senderId;
	
	@NotNull(message="To Account ID is mandatory")
	private Integer recieverId;
	
	@NotNull(message="Amount is mandatory")
	@Min(value=1000, message="Can transfer minimum Rs. 1000")
	@Max(value=50000, message="Can transfer maximum Rs. 50000")
	private Double amount;

	public Integer getSenderId() {
		return senderId;
	}

	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}

	public Integer getRecieverId() {
		return recieverId;
	}

	public void setRecieverId(Integer recieverId) {
		this.recieverId = recieverId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	
	
}
