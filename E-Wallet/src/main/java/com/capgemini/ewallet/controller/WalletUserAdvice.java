package com.capgemini.ewallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import com.capgemini.ewallet.exception.WalletUserException;
import com.capgemini.ewallet.exception.ErrorInfo;

@RestControllerAdvice
public class WalletUserAdvice {
	@ExceptionHandler(value = {WalletUserException.class})

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	
	public ErrorInfo handleException1(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}
