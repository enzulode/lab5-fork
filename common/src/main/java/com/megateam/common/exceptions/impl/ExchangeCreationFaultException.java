package com.megateam.common.exceptions.impl;

import com.megateam.common.exceptions.ResolverException;

/**
 * This exception is thrown if exchange creation was failed
 */
public class ExchangeCreationFaultException extends ResolverException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public ExchangeCreationFaultException(String message)
	{
		super(message);
	}
}
