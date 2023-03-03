package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ResolverException;

/**
 * This exception is thrown if file the file resolving not succeed
 */
public class FileResolvingFailedException extends ResolverException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public FileResolvingFailedException(String message)
	{
		super(message);
	}
}
