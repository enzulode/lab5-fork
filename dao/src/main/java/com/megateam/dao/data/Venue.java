package com.megateam.dao.data;

import javax.xml.bind.annotation.*;
import java.util.Objects;
import java.util.Random;

/**
 * Venue class contains information about ticket venue
 */
@XmlRootElement(name = "venue")
@XmlAccessorType(XmlAccessType.FIELD)
public class Venue
{
	/**
	 * Field contains unique venue id
	 */
	@XmlAttribute(name = "venueId", required = true)
	private long id;

	/**
	 * Field contains venue name
	 */
	@XmlElement(name = "venueName", required = true)
	private String name;

	/**
	 * Field contains venue capacity
	 */
	@XmlElement(name = "capacity", required = true)
	private Integer capacity;

	/**
	 * Field contains venue type
	 */
	@XmlElement(name = "venueType", required = true)
	private VenueType type;

	/**
	 * Class for creating an instance of Venue class
	 */
	public static class VenueBuilder
	{
		/**
		 * Field contains venue builder name
		 */
		private String name;

		/**
		 * Field contains venue builder capacity
		 */
		private Integer capacity;

		/**
		 * Field contains venue builder type
		 */
		private VenueType type;

		/**
		 * Default builder constructor
		 */
		private VenueBuilder() {}

		/**
		 * Venue name setter
		 * @param name venue name
		 * @return instance of VenueBuilder class
		 */
		public VenueBuilder setName(String name)
		{
			this.name = name;
			return this;
		}

		/**
		 * Venue capacity setter
		 * @param capacity venue capacity
		 * @return instance of VenueBuilder class
		 */
		public VenueBuilder setCapacity(Integer capacity)
		{
			this.capacity = capacity;
			return this;
		}

		/**
		 * Venue type setter
		 * @param type venue type
		 * @return instance of VenueBuilder class
		 */
		public VenueBuilder setType(VenueType type)
		{
			this.type = type;
			return this;
		}

		/**
		 * Method creates venue object
		 * @return Venue class instance
		 */
		public Venue build()
		{
			return new Venue(this);
		}
	}

	/**
	 * Default constructor for marshalling & unmarshalling
	 */
	public Venue() {}

	/**
	 * Venue class constructor
	 * @param builder is constructor instance with defined values
	 */
	private Venue(VenueBuilder builder)
	{
		Random random = new Random();
		this.id = random.nextLong(1, Long.MAX_VALUE);

		this.name = builder.name;
		this.capacity = builder.capacity;
		this.type = builder.type;
	}

	/**
	 * Venue id getter
	 * @return venue id value
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Venue name getter
	 * @return venue name value
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Venue capacity getter
	 * @return venue capacity value
	 */
	public Integer getCapacity()
	{
		return capacity;
	}

	/**
	 * Venue type getter
	 * @return venue type value
	 */
	public VenueType getType()
	{
		return type;
	}

	/**
	 * Method creates string representation of existing venue object
	 * @return string representation of venue
	 */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Venue:").append('\n');
		sb.append(String.format("id: %d", id)).append('\n');
		sb.append(String.format("name: %s", name)).append('\n');
		sb.append(String.format("capacity: %d", capacity)).append('\n');
		sb.append(String.format("type: %s", (type == null) ? "is not defined" : type.name())).append('\n');

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
		if (!(obj instanceof Venue venue)) return false;
		if (id != venue.id) return false;
		if (!Objects.equals(name, venue.name)) return false;
		if (!Objects.equals(capacity, venue.capacity)) return false;
		return type == venue.type;
	}

	/**
	 * Generates hashcode for exact object
	 * @return hash code value for exact object
	 */
	@Override
	public int hashCode()
	{
		int result = (int) id;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		return result;
	}

	/**
	 * Method that provides you access to VenueBuilder class
	 * @return VenueBuilder class instance
	 */
	public static VenueBuilder builder()
	{
		return new VenueBuilder();
	}

}
