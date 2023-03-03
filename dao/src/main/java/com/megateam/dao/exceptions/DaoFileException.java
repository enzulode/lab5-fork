package com.megateam.dao.exceptions;

/**
 * This class represents a group of exceptions connected with dao saving file
 */
public abstract class DaoFileException extends Exception
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DaoFileException(String message)
	{
		super(message);
	}
}
