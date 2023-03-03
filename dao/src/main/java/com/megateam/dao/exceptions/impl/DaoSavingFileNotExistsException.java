package com.megateam.dao.exceptions.impl;

import com.megateam.dao.exceptions.DaoFileException;

/**
 * This exception is thrown if dao saving file is not exists
 */
public class DaoSavingFileNotExistsException extends DaoFileException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DaoSavingFileNotExistsException(String message)
	{
		super(message);
	}

}
