package com.grocerystore.dao.exception;

public class DatabaseException extends Exception {
	
	private static final long serialVersionUID = -1385924618170252420L;

	public DatabaseException()
	{
		super();
	}

	public DatabaseException(String s)
	{
		super(s);
	}
	
    public DatabaseException(String s, Throwable cause) {
        super(s, cause);
    }
}
