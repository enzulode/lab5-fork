package com.megateam.dao.exceptions;

/**
 * This exception is thrown if user is trying to save a null dao object
 */
public class EmptyDaoToWriteException extends Exception
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public EmptyDaoToWriteException(String message)
	{
		super(message);
	}

}
