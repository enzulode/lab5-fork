package com.megateam.dao;

import com.megateam.dao.data.Ticket;
import com.megateam.dao.util.LocalDateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is dao and contains tickets collection
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketDao implements Dao<Ticket>
{
	/**
	 * Field contains a dao creation date
	 */
	@XmlElement(name = "daoCreationDate", required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime creationDate;

	/**
	 * Field contains a list of tickets
	 */
	@XmlElementWrapper(name = "tickets")
	@XmlElement(name = "ticket")
	private final List<Ticket> tickets;

	/**
	 * TicketDao default constructor
	 */
	public TicketDao()
	{
		this.tickets = new ArrayList<>();
		this.creationDate = LocalDateTime.now(ZoneId.systemDefault());
	}

	/**
	 * Method returns dao creation date
	 * @return dao creation date
	 */
	@Override
	public LocalDateTime getCreationDate()
	{
		return creationDate;
	}

	/**
	 * Method provides inserting an item into dao
	 * @param item item to be inserted
	 */
	@Override
	public void add(Ticket item)
	{
		if (item == null)
			return;

		tickets.add(item);
	}

	/**
	 * Method retrieves an item for specified id
	 * @param id requested id
	 * @return returns optional value of declared type for requested id
	 */
	@Override
	public Optional<Ticket> get(Integer id)
	{
		if (id == null)
			return Optional.empty();

		for (Ticket ticket : tickets)
		{
			if (ticket.getId().equals(id))
			{
				return Optional.of(ticket);
			}
		}

		return Optional.empty();
	}

	/**
	 * Method retrieves all items stored in dao
	 * @return list of item from the dao
	 */
	@Override
	public List<Ticket> getAll()
	{
		return tickets;
	}

	/**
	 * Method updates existing element in dao with the new item
	 * @param id existing item id
	 * @param item new item
	 */
	@Override
	public void update(Integer id, Ticket item)
	{
		if (id == null || item == null)
			return;

		int idx = 0;
		for (Ticket ticket : tickets)
		{
			if (ticket.getId().equals(id))
			{
				tickets.set(idx, item);
			}
			idx++;
		}
	}

	/**
	 * Method deletes an existing item for specified id
	 * @param id specified id
	 */
	@Override
	public void delete(Integer id)
	{
		if (id == null)
			return;

		int idx = 0;
		for (Ticket ticket : tickets)
		{
			if (ticket.getId().equals(id))
			{
				tickets.remove(idx);
				return;
			}
			idx++;
		}
	}

	/**
	 * Method removes all elements from the dao
	 */
	@Override
	public void clear()
	{
		tickets.clear();
	}

	/**
	 * Method removes first element stored in dao
	 */
	@Override
	public void removeFirst()
	{
		if (tickets.size() > 0)
			tickets.remove(0);
	}

	/**
	 * Method removes last element stored in dao
	 */
	@Override
	public void removeLast()
	{
		if (tickets.size() > 0)
			tickets.remove(tickets.size() - 1);
	}
}
