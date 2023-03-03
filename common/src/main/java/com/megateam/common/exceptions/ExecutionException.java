package com.megateam.common.exceptions;

/**
 * This exception represents a group of exceptions that can be thrown during execution process
 */
public abstract class ExecutionException extends Exception
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public ExecutionException(String message)
	{
		super(message);
	}
}
