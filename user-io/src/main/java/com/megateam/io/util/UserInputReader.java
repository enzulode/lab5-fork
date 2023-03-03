package com.megateam.io.util;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Class for reading user input from console
 */
public class UserInputReader
{
	/**
	 * Contains scanner for reading user input
	 */
	private final Scanner scanner;

	/**
	 * Contains printer for printing user hints
	 */
	private final Printer printer;

	/**
	 * User input reader constructor
	 * @param inputStream input stream for reading
	 */
	public UserInputReader(InputStream inputStream)
	{
		if (inputStream == null)
		{
			scanner = new Scanner(System.in);
		}
		else
		{
			scanner = new Scanner(inputStream);
		}

		printer = new ConsolePrinter();
	}

	/**
	 * Method reads input string from the input stream (defined via constructor)
	 * @return string retrieved via scanner
	 */
	public String read()
	{
		printer.print("Enter command: ");
		return scanner.nextLine();
	}

}
