package com.megateam.handling.resolvers;

import com.megateam.common.commands.Command;
import com.megateam.common.commands.impl.SaveCommand;
import com.megateam.common.exceptions.ResolverException;
import com.megateam.common.exceptions.impl.DefaultResolverUsedException;
import com.megateam.handling.exchanges.Exchange;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * An interface to declare different resolving methods for different situations
 */
public interface Resolver
{
	/**
	 * An immutable variable - registry of implemented commands
	 */
	Map<String, Command> COMMAND_REGISTRY = new HashMap<>() {{
		put("save", new SaveCommand());
	}};

	/**
	 * Methods resolves an Exchange from the user input
	 * @param line user input string
	 * @return an optional value of exchange
	 * @throws ResolverException if something went wrong during the resolving process
	 */
	default Optional<Exchange> resolve(String line) throws ResolverException
	{
		throw new DefaultResolverUsedException("You are trying to use default resolving method. It's not possible.");
	}

	/**
	 * Methods resolves an Exchange from the specified file
	 * @param script file for resolving
	 * @return an optional value of exchange
	 * @throws ResolverException if something went wrong during the resolving process
	 */
	default Optional<Exchange> resolve(File script) throws ResolverException
	{
		throw new DefaultResolverUsedException("You are trying to use default resolving method. It's not possible.");
	}
}
