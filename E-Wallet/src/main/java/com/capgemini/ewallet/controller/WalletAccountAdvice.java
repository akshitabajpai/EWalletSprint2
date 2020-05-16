package com.capgemini.ewallet.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.ewallet.exception.ErrorInfo;
import com.capgemini.ewallet.exception.EwalletException;

@RestControllerAdvice
public class  WalletAccountAdvice {
	@ExceptionHandler(value = {EwalletException.class})
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	public ErrorInfo handleException1(Exception ex) {
		return new ErrorInfo(ex.getMessage());
	}
}