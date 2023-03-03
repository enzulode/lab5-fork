package com.megateam.handling;

import com.megateam.common.exceptions.ExecutionException;
import com.megateam.common.exceptions.ResolverException;
import com.megateam.dao.Dao;
import com.megateam.dao.TicketDao;
import com.megateam.dao.data.Ticket;
import com.megateam.io.util.ConsolePrinter;
import com.megateam.io.util.Printer;
import com.megateam.handling.exchanges.Exchange;
import com.megateam.handling.executors.Executor;
import com.megateam.handling.executors.impl.SingleCommandExecutor;
import com.megateam.handling.resolvers.Resolver;
import com.megateam.handling.resolvers.impl.SingleCommandResolver;
import com.megateam.io.util.UserInputReader;
import sun.misc.Signal;

import java.io.InputStream;
import java.util.Optional;

/**
 * User console wrapper
 */
public class Console
{
	/**
	 * Contains printer instance
	 */
	private final Printer printer;

	/**
	 * Contains user input reader instance
	 */
	private final UserInputReader inputUtility;

	/**
	 * Dao instance to interact with
	 */
	private final Dao<Ticket> dao;

	/**
	 * User console wrapper constructor
	 * @param inputStream default input stream for the application
	 */
	public Console(InputStream inputStream)
	{
		printer = new ConsolePrinter();
		inputUtility = new UserInputReader(inputStream);
		dao = new TicketDao();
	}

	/**
	 * Method initiates command listening
	 */
	public void run()
	{
		Resolver resolver = new SingleCommandResolver(dao);
		Executor executor = new SingleCommandExecutor();

		do
		{
			try
			{
				Optional<Exchange> exchange = resolver.resolve(inputUtility.read());

				if (exchange.isPresent())
				{
					executor.execute(exchange.get());
				}

				Signal.handle(new Signal("INT"), sig -> {
					printer.println("\nGot a killing signal! Graceful shutdown initiated...");
					System.exit(0);
				});
			}
			catch (ResolverException | ExecutionException e)
			{
				printer.println(e.getMessage());
			}
			catch (Exception e)
			{
				printer.println("You have entered something bad. You are not enough worthy to use this app...");
				printer.println("Initiating graceful shutdown...");
				System.exit(0);
			}
		} while (true);
	}

}
