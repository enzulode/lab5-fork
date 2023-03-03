package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ExecutionException;

/**
 * This exception is thrown if you are trying to execute an already executed file
 */
public class FileExecutionAlreadyInProgressException extends ExecutionException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public FileExecutionAlreadyInProgressException(String message)
	{
		super(message);
	}
}
