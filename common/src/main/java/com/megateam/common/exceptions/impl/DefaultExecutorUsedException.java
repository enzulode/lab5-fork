package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ExecutionException;

/**
 * This exception is thrown if the default implementation of execute method was invoked
 */
public class DefaultExecutorUsedException extends ExecutionException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DefaultExecutorUsedException(String message)
	{
		super(message);
	}
}
