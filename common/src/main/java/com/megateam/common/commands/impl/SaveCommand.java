package com.megateam.common.commands.impl;

import com.megateam.common.commands.Command;
import com.megateam.common.exceptions.ExecutionException;
import com.megateam.common.util.CommandSource;
import com.megateam.dao.exceptions.DaoFileException;
import com.megateam.dao.exceptions.EmptyDaoToWriteException;

import java.util.List;

public class SaveCommand extends Command
{
	/**
	 * Command class constructor defines basic command properties
	 */
	public SaveCommand()
	{
		super("save", "command saves ticket's collection into a file");
	}

	/**
	 * Method contains command logic
	 * @param args list of arguments for exact command
	 * @param source specifies the where the command being executed from
	 * @return command execution status
	 */
	@Override
	public boolean execute(List<String> args, CommandSource source)
	{
		try
		{
			dao.save();
			printer.println("Tickets had been saved successfully.");
			return true;
		}
		catch (DaoFileException | EmptyDaoToWriteException e)
		{
			printer.println(e.getMessage());
			return false;
		}
	}
}
