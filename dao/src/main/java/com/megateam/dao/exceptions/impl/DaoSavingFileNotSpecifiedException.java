package com.megateam.dao.exceptions.impl;

import com.megateam.dao.exceptions.DaoFileException;

/**
 * This exception is thrown if dao saving file is not specified
 */
public class DaoSavingFileNotSpecifiedException extends DaoFileException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DaoSavingFileNotSpecifiedException(String message)
	{
		super(message);
	}

}
