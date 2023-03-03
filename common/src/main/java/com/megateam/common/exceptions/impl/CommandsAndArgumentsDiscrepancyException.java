package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ExecutionException;

/**
 * This exception is thrown if amount of commands differs from amount of arguments lists
 */
public class CommandsAndArgumentsDiscrepancyException extends ExecutionException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public CommandsAndArgumentsDiscrepancyException(String message)
	{
		super(message);
	}
}
