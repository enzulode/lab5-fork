package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ResolverException;

/**
 * This exception could be thrown if during the resolving process command was not found
 */
public class CommandNotFoundException extends ResolverException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public CommandNotFoundException(String message)
	{
		super(message);
	}
}
