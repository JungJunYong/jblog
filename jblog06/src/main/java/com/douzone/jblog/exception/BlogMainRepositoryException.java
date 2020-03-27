package com.douzone.jblog.exception;

public class BlogMainRepositoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public BlogMainRepositoryException() {
		super("BlogMainRepositoryException Occurs");
	}
	public BlogMainRepositoryException(String Message) {
		super(Message);
	}
}
