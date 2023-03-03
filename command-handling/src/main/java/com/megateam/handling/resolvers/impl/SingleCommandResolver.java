package com.megateam.handling.resolvers.impl;

import com.megateam.common.commands.Command;
import com.megateam.common.exceptions.ResolverException;
import com.megateam.common.exceptions.impl.CommandNotFoundException;
import com.megateam.dao.Dao;
import com.megateam.dao.data.Ticket;
import com.megateam.handling.exchanges.Exchange;
import com.megateam.handling.resolvers.Resolver;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Single command resolver
 */
public class SingleCommandResolver implements Resolver
{
	/**
	 * Dao instance to interact with
	 */
	private final Dao<Ticket> dao;

	/**
	 * Default class constructor
	 */
	public SingleCommandResolver(Dao<Ticket> dao)
	{
		this.dao = dao;
	}

	/**
	 * Method returns an optional value of resolved command exchange
	 * @param line user input line
	 * @return optional exchange object
	 * @throws ResolverException if something gone wrong during resolving the command
	 */
	@Override
	public Optional<Exchange> resolve(String line) throws ResolverException
	{
		String[] sepLine = line.trim().split(" ");

//		check if requested command exists in COMMAND_REGISTRY
		if (!COMMAND_REGISTRY.containsKey(sepLine[0]))
			throw new CommandNotFoundException("Requested command not found! Please, try again.");

		Command command = COMMAND_REGISTRY.get(sepLine[0]);

//		check if retrieved command is null
		if (command == null)
			throw new CommandNotFoundException("Retrieved null command from command registry. Something gone wrong.");

//		parse command arguments from split input line
		List<String> arguments = List.of(Arrays.copyOfRange(sepLine, 1, sepLine.length));

		Exchange exchange = Exchange.builder(dao)
				.setCommand(command)
				.setArguments(arguments)
				.build();

		return Optional.of(exchange);
	}
}
