package com.megateam.dao.exceptions.impl;

import com.megateam.dao.exceptions.DaoFileException;

/**
 * This exception is thrown if dao saving file is not readable
 */
public class DaoSavingFileNotReadable extends DaoFileException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DaoSavingFileNotReadable(String message)
	{
		super(message);
	}

}
