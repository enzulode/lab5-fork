package com.megateam.dao.data;

import com.megateam.dao.util.LocalDateTimeAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import java.util.Random;

/**
 * Ticket class contains information about ticket
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Ticket implements Comparable<Ticket>
{
	/**
	 * Field contains unique ticket id
	 */
	@XmlAttribute(name = "ticketId", required = true)
	private Integer id;

	/**
	 * Field contains ticket name
	 */
	@XmlElement(name = "ticketName", required = true)
	private String name;

	/**
	 * Field contains ticket coordinates
	 */
	@XmlElement(name = "ticketCoordinates", required = true)
	private Coordinates coordinates;

	/**
	 * Field contains ticket creation date
	 */
	@XmlElement(name = "creationDate", required = true)
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	private LocalDateTime creationDate;

	/**
	 * Field contains ticket price
	 */
	@XmlElement(name = "ticketPrice", required = true)
	private float price;

	/**
	 * Field contains ticket comment
	 */
	@XmlElement(name = "ticketComment", required = true)
	private String comment;

	/**
	 * Field contains ticket refundable status
	 */
	@XmlElement(name = "refundable", required = true)
	private Boolean refundable;

	/**
	 * Field contains ticket type
	 */
	@XmlElement(name = "ticketType", required = true)
	private TicketType type;

	/**
	 * Field contains ticket venue
	 */
	@XmlElement(name = "ticketVenue", required = true)
	private Venue venue;

	/**
	 * Class for creating an instance of Venue class
	 */
	public static class TicketBuilder
	{
		/**
		 * Field contains builder ticket name
		 */
		private String name;

		/**
		 * Field contains builder ticket coordinates
		 */
		private Coordinates coordinates;

		/**
		 * Field contains builder ticket price
		 */
		private float price;

		/**
		 * Field contains builder ticket comment
		 */
		private String comment;

		/**
		 * Field contains builder ticket refundable status
		 */
		private Boolean refundable;

		/**
		 * Field contains builder ticket type
		 */
		private TicketType type;

		/**
		 * Field contains builder ticket venue
		 */
		private Venue venue;

		/**
		 * Default builder constructor
		 */
		private TicketBuilder() {}

		/**
		 * Ticket name setter
		 * @param name ticket name
		 * @return instance of TicketBuilder class
		 */
		public TicketBuilder setName(String name)
		{
			this.name = name;
			return this;
		}

		/**
		 * Ticket coordinates setter
		 * @param coordinates ticket coordinates
		 * @return instance of TicketBuilder class
		 */
		public TicketBuilder setCoordinates(Coordinates coordinates)
		{
			this.coordinates = coordinates;
			return this;
		}

		/**
		 * Ticket price setter
		 * @param price ticket price
		 * @return instance of TicketBuilder class
		 */
		public TicketBuilder setPrice(float price)
		{
			this.price = price;
			return this;
		}

		/**
		 * Ticket comment setter
		 * @param comment ticket comment
		 * @return instance of TicketBuilder class
		 */
		public TicketBuilder setComment(String comment)
		{
			this.comment = comment;
			return this;
		}

		/**
		 * Ticket refundable setter
		 * @param refundable ticket refundable
		 * @return instance of TicketBuilder class
		 */
		public TicketBuilder setRefundable(Boolean refundable)
		{
			this.refundable = refundable;
			return this;
		}

		/**
		 * Ticket type setter
		 * @param type ticket type
		 * @return instance of TicketBuilder class
		 */
		public TicketBuilder setType(TicketType type)
		{
			this.type = type;
			return this;
		}

		/**
		 * Ticket venue setter
		 * @param venue ticket venue
		 * @return instance of TicketBuilder class
		 */
		public TicketBuilder setVenue(Venue venue)
		{
			this.venue = venue;
			return this;
		}

		/**
		 * Method creates ticket object
		 * @return Ticket class instance
		 */
		public Ticket build()
		{
			return new Ticket(this);
		}
	}

	/**
	 * Default constructor for correct marshalling & unmarshalling
	 */
	public Ticket() {}

	/**
	 * Ticket class constructor
	 * @param builder is constructor instance with defined values
	 */
	private Ticket(TicketBuilder builder)
	{
		Random random = new Random();
		this.id = random.nextInt(1, Integer.MAX_VALUE);
		this.creationDate = LocalDateTime.now(ZoneId.systemDefault());

		this.name = builder.name;
		this.coordinates = builder.coordinates;
		this.price = builder.price;
		this.comment = builder.comment;
		this.refundable = builder.refundable;
		this.type = builder.type;
		this.venue = builder.venue;
	}

	/**
	 * Ticket id getter
	 * @return ticket id value
	 */
	public Integer getId()
	{
		return id;
	}

	/**
	 * Ticket name getter
	 * @return ticket name value
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Ticket coordinates getter
	 * @return ticket coordinates value
	 */
	public Coordinates getCoordinates()
	{
		return coordinates;
	}

	/**
	 * Ticket creation date getter
	 * @return ticket creation date value
	 */
	public LocalDateTime getCreationDate()
	{
		return creationDate;
	}

	/**
	 * Ticket price getter
	 * @return ticket price value
	 */
	public float getPrice()
	{
		return price;
	}

	/**
	 * Ticket comment getter
	 * @return ticket comment value
	 */
	public String getComment()
	{
		return comment;
	}

	/**
	 * Ticket refundable getter
	 * @return ticket refundable value
	 */
	public Boolean getRefundable()
	{
		return refundable;
	}

	/**
	 * Ticket type getter
	 * @return ticket type value
	 */
	public TicketType getType()
	{
		return type;
	}

	/**
	 * Ticket venue getter
	 * @return ticket venue value
	 */
	public Venue getVenue()
	{
		return venue;
	}

	/**
	 * Method for comparing ticket objects
	 * @param ticket the object to be compared
	 * @return 0 if current object is equal to specified one
	 * -1 if current object is less than specified one
	 * 1 if current object is greater than specified one
	 */
	@Override
	public int compareTo(Ticket ticket)
	{
		if (ticket.equals(this)) return 0;
		return (id < ticket.id) ? -1 : 1;
	}

	/**
	 * Method creates string representation of existing ticket object
	 * @return string representation of ticket
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Ticket:").append('\n');
		sb.append(String.format("id: %d", id)).append('\n');
		sb.append(String.format("creationDate: %s", creationDate.toString())).append('\n');
		sb.append(String.format("name: %s", name)).append('\n');
		sb.append(String.format("coordinates: %s", coordinates.toString())).append('\n');
		sb.append(String.format("price: %f", price)).append('\n');
		sb.append(String.format("comment: %s", comment)).append('\n');
		sb.append(String.format("refundable: %b", refundable)).append('\n');
		sb.append(String.format("type: %s", (type == null) ? "not defined" : type.name())).append('\n');
		sb.append(String.format("venue: %s", venue.toString())).append('\n');

		return sb.toString();
	}

	/**
	 * Method checks current object is equal to specified one
	 * @param obj another venue object
	 * @return true if objects are equal, false if they are different
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof Ticket ticket)) return false;
		if (!Objects.equals(id, ticket.id)) return false;
		if (!Objects.equals(creationDate, ticket.creationDate)) return false;
		if (!Objects.equals(name, ticket.name)) return false;
		if (!Objects.equals(coordinates, ticket.coordinates)) return false;
		if (price != ticket.price) return false;
		if (!Objects.equals(comment, ticket.comment)) return false;
		if (!Objects.equals(refundable, ticket.refundable)) return false;
		if (type != ticket.type) return false;
		return Objects.equals(venue, ticket.venue);
	}

	/**
	 * Generates hashcode for exact object
	 * @return hash code value for exact object
	 */
	@Override
	public int hashCode()
	{
		int result = id.hashCode();
		result = 31 * result + creationDate.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
		result = 31 * result + (int) price;
		result = 31 * result + (comment != null ? comment.hashCode() : 0);
		result = 31 * result + (refundable != null ? refundable.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (venue != null ? venue.hashCode() : 0);

		return result;
	}

	/**
	 * Method that provides you access to TicketBuilder class
	 * @return TicketBuilder class instance
	 */
	public static TicketBuilder builder()
	{
		return new TicketBuilder();
	}
}
