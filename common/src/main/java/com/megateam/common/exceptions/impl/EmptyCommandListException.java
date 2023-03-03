package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ExecutionException;

/**
 * This exception is thrown if empty command list was specified for execution
 */
public class EmptyCommandListException extends ExecutionException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public EmptyCommandListException(String message)
	{
		super(message);
	}
}
