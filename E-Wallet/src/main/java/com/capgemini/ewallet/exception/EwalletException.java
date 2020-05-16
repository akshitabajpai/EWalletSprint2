package com.capgemini.ewallet.exception;

public class EwalletException extends RuntimeException {
	private static final long serialVersionUID = 1L;
     
	public EwalletException() {
		super();
			}

	public EwalletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
			}

	public EwalletException(String message, Throwable cause) {
		super(message, cause);
			}

	public EwalletException(String message) {
		super(message);
	}

	public EwalletException(Throwable cause) {
		super(cause);
			}
	
    
}