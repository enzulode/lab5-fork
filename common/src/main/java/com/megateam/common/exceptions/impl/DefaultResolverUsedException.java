package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ResolverException;

/**
 * This exception is thrown if the default implementation of resolve method was invoked
 */
public class DefaultResolverUsedException extends ResolverException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DefaultResolverUsedException(String message)
	{
		super(message);
	}
}
