package com.megateam.common.exceptions;

/**
 * This exception represents a group of exceptions that can be thrown during resolving process
 */
public abstract class ResolverException extends Exception
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public ResolverException(String message)
	{
		super(message);
	}
}
