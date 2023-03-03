package com.megateam.dao;

import com.megateam.dao.data.Ticket;
import com.megateam.dao.exceptions.*;
import com.megateam.dao.exceptions.impl.*;
import com.megateam.dao.util.LocalDateTimeAdapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Class is responsible for ticket dao files manipulations
 */
public class TicketDaoFileManipulator
{
	/**
	 * Method is trying to get file to save dao elements in a file
	 * @return returns a file where dao information will be stored
	 * @throws DaoSavingFileNotSpecifiedException if dao file is not specified the exception will be thrown
	 */
	private static File retrieveDaoSavingFile() throws DaoFileException
	{
		String filename = System.getenv("SAVING_VAR");

		if ("".equals(filename) || filename == null)
			throw new DaoSavingFileNotSpecifiedException("There is no dao saving file specified in SAVING_VAR variable");

		File resultFile = new File(filename);

		if (!resultFile.exists())
			throw new DaoSavingFileNotExistsException("There is no file: " + filename);

		return resultFile;
	}

	/**
	 * Writes specified dao into a file
	 * @param ticketDao writable dao
	 */
	public static void write(Dao<Ticket> ticketDao) throws DaoFileException, EmptyDaoToWriteException
	{
//		check if ticketDao is null
		if (ticketDao == null)
			throw new EmptyDaoToWriteException("You are trying to write non-existing dao!");

//		retrieving a dao saving file
		File file = retrieveDaoSavingFile();

//		check if file is not writable (you may not have enough permissions to write a file)
		if (!Files.isWritable(file.toPath().toAbsolutePath()))
			throw new DaoFileNotWritableException("Specified file is not writable. Check out the permissions.");

//		trying to marshal ticket dao
		try (FileOutputStream fos = new FileOutputStream(file))
		{
			JAXBContext context = JAXBContext.newInstance(TicketDao.class);
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.setAdapter(new LocalDateTimeAdapter());
			mar.marshal(ticketDao, fos);
		}
		catch (IOException e)
		{
			throw new DaoSavingFileStreamNotOpenedException("Got some troubles during saving file opening.");
		}
		catch (JAXBException e)
		{
			throw new DaoSavingFileIncorrectException("Something gone wrong during marshaling ticket to saving file.");
		}
	}

	/**
	 * Retrieves dao from the saving file
	 * @return ticket dao object
	 * @throws DaoFileException if some problems occurred while reading file
	 */
	public static Dao<Ticket> read() throws DaoFileException
	{
//		retrieving a dao saving file
		File file = retrieveDaoSavingFile();

//		check if file is not readable (you may not have enough permissions to read a file)
		if (!Files.isReadable(file.toPath().toAbsolutePath()))
			throw new DaoSavingFileNotReadable("Specified file is not readable. Check out the permissions.");

//		trying to unmarshal ticket dao
		try
		{
			JAXBContext context = JAXBContext.newInstance(TicketDao.class);
			Unmarshaller unmar = context.createUnmarshaller();
			unmar.setAdapter(new LocalDateTimeAdapter());
			return (TicketDao) unmar.unmarshal(file);
		}
		catch (JAXBException e)
		{
			throw new DaoSavingFileIncorrectException("Dao saving file is incorrect. Fix it and try again.");
		}
	}

}
