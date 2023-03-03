package com.megateam.dao.exceptions.impl;

import com.megateam.dao.exceptions.DaoFileException;

/**
 * This exception is thrown if dao saving file is incorrect
 */
public class DaoSavingFileIncorrectException extends DaoFileException
{
	/**
	 * Default exception constructor
	 * @param message exception message
	 */
	public DaoSavingFileIncorrectException(String message)
	{
		super(message);
	}

}
