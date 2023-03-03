package com.megateam.handling.executors;

import com.megateam.common.commands.Command;
import com.megateam.common.exceptions.ExecutionException;
import com.megateam.common.exceptions.impl.DefaultExecutorUsedException;
import com.megateam.handling.exchanges.Exchange;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Executor interface - declares methods for different types of executors
 */
public interface Executor
{
	/**
	 * Set of currently executed files
	 */
	Set<File> EXECUTED_FILES = new HashSet<>();

	/**
	 * Method executes single command with specified arguments
	 * @param exchange contains required information for command execution
	 * @return execution status
	 * @throws ExecutionException if something gone wrong during execution
	 */
	default boolean execute(Exchange exchange) throws ExecutionException
	{
		throw new DefaultExecutorUsedException("You are trying to use default executing method. It's not possible.");
	}

	/**
	 * Method executes commands from the list of them
	 * @param executingFile executing file (for recursion prevention logic)
	 * @param exchange contains required information for command execution
	 * @return script execution status
	 * @throws ExecutionException if something gone wrong during script execution
	 */
	default boolean execute(File executingFile, Exchange exchange)
			throws ExecutionException
	{
		throw new DefaultExecutorUsedException("You are trying to use default executing method. It's not possible.");
	}

}
