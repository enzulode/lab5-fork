package com.megateam.handling.resolvers.impl;

import com.megateam.common.commands.Command;
import com.megateam.common.exceptions.ResolverException;
import com.megateam.common.exceptions.impl.FileResolvingFailedException;
import com.megateam.dao.Dao;
import com.megateam.dao.data.Ticket;
import com.megateam.handling.exchanges.Exchange;
import com.megateam.handling.resolvers.Resolver;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Script commands resolver
 */
public class ScriptCommandsResolver implements Resolver
{

	/**
	 * Dao instance to interact with
	 */
	private final Dao<Ticket> dao;

	/**
	 * Default class constructor
	 */
	public ScriptCommandsResolver(Dao<Ticket> dao)
	{
		this.dao = dao;
	}

	/**
	 * Method resolves a script commands
	 * @param script script to be resolved
	 * @return optional value of an exchange
	 * @throws ResolverException if something went wrong during file reading
	 */
	@Override
	public Optional<Exchange> resolve(File script) throws ResolverException
	{
		try(BufferedReader reader = new BufferedReader(new FileReader(script)))
		{
//			retrieving all file lines
			List<String> fileLines = reader.lines().toList();

//			inited empty lists for commands & arguments
			List<Command> commands = new LinkedList<>();
			List<List<String>> listOfArguments = new LinkedList<>();

//			current command
			int commandPointer = -1;


			for(String line : fileLines)
			{
				String[] splittedLine = line.split(" ");

				if (COMMAND_REGISTRY.containsKey(splittedLine[0]))
				{
					commandPointer++;
					Command currentCommand = COMMAND_REGISTRY.get(splittedLine[0]);
					commands.add(commandPointer, currentCommand);

					if (listOfArguments.size()-1 < commandPointer)
						listOfArguments.add(new LinkedList<>());

					listOfArguments.get(commandPointer).addAll(
							Arrays.asList(Arrays.copyOfRange(splittedLine, 1, splittedLine.length))
					);
				}
				else
				{
					listOfArguments.get(commandPointer).add(line);
				}
			}

			Exchange exchange = Exchange.builder(dao)
					.setCommands(commands)
					.setListOfArguments(listOfArguments)
					.build();

			return Optional.of(exchange);
		}
		catch (IOException e)
		{
			throw new FileResolvingFailedException("Failed to resolve specified file: " + e.getMessage());
		}
	}
}
