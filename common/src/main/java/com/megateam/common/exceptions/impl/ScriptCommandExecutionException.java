package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ExecutionException;

/**
 * This exception is thrown if during the script execution some command's execution errored
 */
public class ScriptCommandExecutionException extends ExecutionException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public ScriptCommandExecutionException(String message)
	{
		super(message);
	}
}
