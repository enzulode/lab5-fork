package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ExecutionException;

/**
 * This exception is thrown if null object of command trying to be executed
 */
public class NullCommandException extends ExecutionException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public NullCommandException(String message)
	{
		super(message);
	}
}
