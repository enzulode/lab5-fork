package com.megateam.common.commands;

import com.megateam.common.exceptions.ExecutionException;
import com.megateam.common.util.CommandSource;
import com.megateam.dao.Dao;
import com.megateam.dao.data.Ticket;
import com.megateam.io.util.ConsolePrinter;
import com.megateam.io.util.Printer;

import java.io.InputStream;
import java.util.List;

/**
 * The main purpose of this class is to contain similar parts of different commands to prevent code duplication
 */
public abstract class Command
{
	/**
	 * Field contains printer instance
	 */
	protected final Printer printer;

	/**
	 * Field contains input stream instance
	 */
	protected InputStream in;

	/**
	 * Field contains command name
	 */
	protected final String name;

	/**
	 * Field contains command description
	 */
	protected final String description;

	/**
	 * Field contains dao to interact with
	 */
	protected Dao<Ticket> dao;

	/**
	 * Command class constructor defines basic command properties
	 * @param name is the command name (will be displayed in help output)
	 * @param description is the command description (will be displayed in help output)
	 */
	protected Command(String name, String description)
	{
		this.name = name;
		this.description = description;
		this.printer = new ConsolePrinter();
	}

	/**
	 * Command name getter
	 * @return command name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Command description getter
	 * @return command description
	 */
	public String getDescription()
	{
		return description;
	}

	/**
	 * Command input source setter
	 * @param in will be set as a command input source
	 * @return current command instance
	 */
	public Command setIn(InputStream in)
	{
		this.in = in;
		return this;
	}

	/**
	 * Dao setter
	 * @param dao dao instance
	 * @return current command instance
	 */
	public Command setDao(Dao<Ticket> dao)
	{
		this.dao = dao;
		return this;
	}

	/**
	 * Method generates a special help string for the exact command
	 * @return formatted help string
	 */
	public String help()
	{
		return String.format("%s - %s", name, description);
	}

	/**
	 * Command execution method
	 * @param args list of arguments for exact command
	 * @param source specifies the where the command being executed from
	 * @return a status of execution: true - successful, false - unsuccessful
	 * @throws ExecutionException if something gone wrong during the execution
	 */
	public abstract boolean execute(List<String> args, CommandSource source) throws ExecutionException;
}
