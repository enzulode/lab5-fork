package com.megateam.handling.executors.impl;

import com.megateam.common.exceptions.ExecutionException;
import com.megateam.common.exceptions.impl.NullCommandException;
import com.megateam.common.util.CommandSource;
import com.megateam.handling.exchanges.Exchange;
import com.megateam.handling.executors.Executor;

/**
 * Single command executor
 */
public class SingleCommandExecutor implements Executor
{
	/**
	 * Method executes a command with specified arguments
	 * @param exchange contains required information for command execution
	 * @return true if the execution succeed
	 * @throws ExecutionException if something gone wring during the execution
	 */
	@Override
	public boolean execute(Exchange exchange) throws ExecutionException
	{
//		check if the specified command variable is null
		if (exchange.getCommand() == null)
			throw new NullCommandException("Command variable is null. Command execution failed.");

		return exchange.getCommand()
				.setIn(System.in)
				.setDao(exchange.getDao())
				.execute(exchange.getArguments(), CommandSource.CONSOLE);
	}
}
