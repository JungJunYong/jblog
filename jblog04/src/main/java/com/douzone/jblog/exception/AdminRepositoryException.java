package com.douzone.jblog.exception;

public class AdminRepositoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public AdminRepositoryException() {
		super("AdminRepositoryException Occurs");
	}
	public AdminRepositoryException(String Message) {
		super(Message);
	}
}
