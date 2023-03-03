package com.megateam.handling.executors.impl;

import com.megateam.common.commands.Command;
import com.megateam.common.exceptions.ExecutionException;
import com.megateam.common.exceptions.impl.CommandsAndArgumentsDiscrepancyException;
import com.megateam.common.exceptions.impl.EmptyCommandListException;
import com.megateam.common.exceptions.impl.FileExecutionAlreadyInProgressException;
import com.megateam.common.exceptions.impl.ScriptCommandExecutionException;
import com.megateam.common.util.CommandSource;
import com.megateam.handling.exchanges.Exchange;
import com.megateam.handling.executors.Executor;

import java.io.File;
import java.util.List;

/**
 * Several commands executor
 */
public class ScriptExecutor implements Executor
{
	/**
	 * Method executes command from the specified list
	 * @param executingFile file script is executed from
	 * @param exchange contains required information for command execution
	 * @return execution status
	 * @throws ExecutionException if something gone wrong during the execution
	 */
	@Override
	public boolean execute(File executingFile, Exchange exchange) throws ExecutionException
	{
//		for recursion prevention executing file should be checked
//		if executing file is now executing - throwing an exception, otherwise add to executed files set
		if (EXECUTED_FILES.contains(executingFile))
		{
			throw new FileExecutionAlreadyInProgressException("Specified file is already executed");
		}
		else
		{
			EXECUTED_FILES.add(executingFile);
		}

//		check if command list is empty
		if (exchange.getListOfArguments().size() == 0)
			throw new EmptyCommandListException("Empty list of commands is trying to be executed.");

//		check if there is discrepancy between amount of commands & amount of argument lists
		if (exchange.getCommands().size() != exchange.getListOfArguments().size())
			throw new CommandsAndArgumentsDiscrepancyException("Commands amount doesn't match to arguments lists");

//		trying to execute commands from list until the exception will be caught
		int idx = 0;
		for (Command command : exchange.getCommands())
		{
			List<String> currentCommandArguments = exchange.getListOfArguments().get(idx++);
			boolean result = command.execute(currentCommandArguments, CommandSource.FILE);

//			if the command execution status if false - throwing an exception
			if (!result)
				throw new ScriptCommandExecutionException("Script command execution failed: " + command.getName());
		}

//		after execution this file should be removed from set of executing ones
		EXECUTED_FILES.remove(executingFile);

		return true;
	}
}
