package com.megateam.dao;

import com.megateam.dao.exceptions.DaoFileException;
import com.megateam.dao.exceptions.EmptyDaoToWriteException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Project Dao abstraction
 * @param <T> type of dao-contained elements
 */
public interface Dao<T>
{

	/**
	 * Method saves dao in the file
	 */
	void save() throws DaoFileException, EmptyDaoToWriteException;

	/**
	 * Method loads dao from the file
	 */
	void load() throws DaoFileException;

	/**
	 * Method returns dao creation date
	 * @return dao creation date
	 */
	LocalDateTime getCreationDate();

	/**
	 * Method provides inserting an item into dao
	 * @param item item to be inserted
	 */
	void add (T item);

	/**
	 * Method retrieves an item for specified id
	 * @param id requested id
	 * @return returns optional value of declared type for requested id
	 */
	Optional<T> get(Integer id);

	/**
	 * Method retrieves all items stored in dao
	 * @return list of item from the dao
	 */
	List<T> getAll();

	/**
	 * Method updates existing element in dao with the new item
	 * @param id existing item id
	 * @param item new item
	 */
	void update(Integer id, T item);

	/**
	 * Method deletes an existing item for specified id
	 * @param id specified id
	 */
	void delete(Integer id);

	/**
	 * Method removes all elements from the dao
	 */
	void clear();

	/**
	 * Method removes first element stored in dao
	 */
	void removeFirst();

	/**
	 * Method removes last element stored in dao
	 */
	void removeLast();
}
