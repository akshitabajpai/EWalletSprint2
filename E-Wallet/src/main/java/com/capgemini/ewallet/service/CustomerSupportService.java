package com.capgemini.ewallet.service;

import java.util.ArrayList;

import java.util.List;


import org.springframework.stereotype.Service;

import com.capgemini.ewallet.exception.WalletUserException;
import com.capgemini.ewallet.entity.CustomerSupport;

import com.capgemini.ewallet.dao.CustomerSupportDao;



public interface CustomerSupportService {
	
	boolean addIssue(CustomerSupport customersupport);
	List<CustomerSupport> getAllIssue();
	
	CustomerSupport saveIssue(CustomerSupport customersupport);

}
	
	
	
	
