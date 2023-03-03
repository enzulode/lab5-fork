package com.megateam.io.util;

/**
 * Application console output abstraction
 */
public interface Printer
{
	/**
	 * Method provides printing string in a current line
	 * @param printable something you want to print
	 */
	void print(String printable);

	/**
	 * Method provides printing string in a next line
	 * @param printable something you want to print
	 */
	void println(String printable);

	/**
	 * Method provides printing formatted string
	 * @param printable something you want to print
	 */
	void printf(String printable, Object... args);
}
