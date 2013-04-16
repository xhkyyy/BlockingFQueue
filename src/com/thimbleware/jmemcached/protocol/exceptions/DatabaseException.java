package com.thimbleware.jmemcached.protocol.exceptions;

/**
 * @author sunli
 * @date 2010-8-23
 * @version $Id: DatabaseException.java 2 2011-07-31 12:25:36Z sunli1223@gmail.com $
 */
public class DatabaseException extends RuntimeException {

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7813092784916606140L;

	public DatabaseException(String message) {
		super(message);
	}

	public DatabaseException(Throwable cause) {
		super(cause);
	}

}
