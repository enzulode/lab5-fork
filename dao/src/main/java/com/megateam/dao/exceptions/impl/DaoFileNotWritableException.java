package com.megateam.dao.exceptions.impl;

import com.megateam.dao.exceptions.DaoFileException;

/**
 * This exception is thrown if dao saving file is not writable due to lack of permissions
 */
public class DaoFileNotWritableException extends DaoFileException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DaoFileNotWritableException(String message)
	{
		super(message);
	}

}
