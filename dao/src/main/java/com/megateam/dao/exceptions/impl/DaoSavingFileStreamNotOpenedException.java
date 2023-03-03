package com.megateam.dao.exceptions.impl;

import com.megateam.dao.exceptions.DaoFileException;

/**
 * This exception is thrown if dao saving file stream opening errored
 */
public class DaoSavingFileStreamNotOpenedException extends DaoFileException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DaoSavingFileStreamNotOpenedException(String message)
	{
		super(message);
	}
}
