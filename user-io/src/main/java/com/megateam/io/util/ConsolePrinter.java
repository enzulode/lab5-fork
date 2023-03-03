package com.megateam.io.util;

/**
 * Application console output implementation
 */
public class ConsolePrinter implements Printer
{
	/**
	 * Method provides printing string in a current line
	 * @param printable something you want to print
	 */
	@Override
	public void print(String printable)
	{
		System.out.print(printable);
	}

	/**
	 * Method provides printing string in a next line
	 * @param printable something you want to print
	 */
	@Override
	public void println(String printable)
	{
		System.out.println(printable);
	}

	/**
	 * Method provides printing formatted string
	 * @param printable something you want to print
	 */
	@Override
	public void printf(String printable, Object... args)
	{
		System.out.printf(printable, args);
	}

}
