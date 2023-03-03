package com.megateam.handling.exchanges;

import com.megateam.common.commands.Command;
import com.megateam.common.exceptions.ResolverException;
import com.megateam.common.exceptions.impl.ExchangeCreationFaultException;
import com.megateam.dao.Dao;
import com.megateam.dao.data.Ticket;

import java.util.*;

public class Exchange
{
	/**
	 * Field contains list of commands
	 */
	private List<Command> commands;

	/**
	 * Field contains list of lists of arguments
	 */
	private List<List<String>> listOfArguments;


	/**
	 * Field contains command instance
	 */
	private Command command;

	/**
	 * Field contains list of arguments
	 */
	private List<String> arguments;

	/**
	 * Field contains ticket dao instance
	 */
	private final Dao<Ticket> dao;

	/**
	 * Exchange builder
	 */
	public static class ExchangeBuilder
	{
		/**
		 * Field contains list of commands
		 */
		private List<Command> commands;

		/**
		 * Field contains list of lists of arguments
		 */
		private List<List<String>> listOfArguments;

		/**
		 * Field contains command instance
		 */
		private Command command;

		/**
		 * Field contains command arguments
		 */
		private List<String> arguments;

		/**
		 * Field contains ticket dao instance
		 */
		private final Dao<Ticket> dao;

		/**
		 * Exchange builder constructor
		 */
		private ExchangeBuilder(Dao<Ticket> dao)
		{
			this.dao = dao;
		}

		/**
		 * Commands field setter
		 * @param commands list of commands
		 * @return builder instance
		 */
		public ExchangeBuilder setCommands(List<Command> commands)
		{
			this.commands = commands;
			return ExchangeBuilder.this;
		}

		/**
		 * ListOfArguments field setter
		 * @param listOfArguments list of lists of arguments
		 * @return builder instance
		 */
		public ExchangeBuilder setListOfArguments(List<List<String>> listOfArguments)
		{
			this.listOfArguments = listOfArguments;
			return ExchangeBuilder.this;
		}

		/**
		 * Command field setter
		 * @param command command instance
		 * @return builder instance
		 */
		public ExchangeBuilder setCommand(Command command)
		{
			this.command = command;
			return ExchangeBuilder.this;
		}

		/**
		 * Arguments field setter
		 * @param arguments list of arguments
		 * @return builder instance
		 */
		public ExchangeBuilder setArguments(List<String> arguments)
		{
			this.arguments = arguments;
			return ExchangeBuilder.this;
		}

		/**
		 * Method creates an instance of exchange from builder instance
		 * @return exchange instance
		 * @throws ResolverException if instance creation excepted
		 */
		public Exchange build() throws ResolverException
		{
			return new Exchange(ExchangeBuilder.this);
		}
	}

	/**
	 * Exchange constructor
	 * @param builder exchange builder instance
	 * @throws ResolverException if it's not possible to create an instance of exchange
	 */
	private Exchange(ExchangeBuilder builder) throws ResolverException
	{
		if (builder.commands != null && builder.listOfArguments != null && builder.dao != null)
		{
			this.dao = builder.dao;
			this.commands = builder.commands;
			this.listOfArguments = builder.listOfArguments;
		}
		else if (builder.command != null && builder.arguments != null)
		{
			this.dao = builder.dao;
			this.command = builder.command;
			this.arguments = builder.arguments;
		}
		else
		{
			throw new ExchangeCreationFaultException("Failed to create an exchange.");
		}
	}

	/**
	 * Command field getter
	 * @return command instance
	 */
	public Command getCommand()
	{
		return command;
	}

	/**
	 * Arguments field getter
	 * @return arguments list
	 */
	public List<String> getArguments()
	{
		return arguments;
	}

	/**
	 * Arguments field getter
	 * @return arguments list
	 */
	public Dao<Ticket> getDao()
	{
		return dao;
	}

	/**
	 * Commands field getter
	 * @return list of command instances
	 */
	public List<Command> getCommands()
	{
		return commands;
	}

	/**
	 * ListOfArguments field getter
	 * @return list of lists of arguments
	 */
	public List<List<String>> getListOfArguments()
	{
		return listOfArguments;
	}

	/**
	 * ExchangeBuilder instance getter
	 * @return ExchangeBuilder instance
	 */
	public static ExchangeBuilder builder(Dao<Ticket> dao)
	{
		return new ExchangeBuilder(dao);
	}
}
