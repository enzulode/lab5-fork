package com.megateam.dao.data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

/**
 * Coordinates class contains information about ticket coordinates
 */
@XmlRootElement(name = "coordinates")
@XmlAccessorType(XmlAccessType.FIELD)
public class Coordinates
{
	/**
	 * Field contains X coordinate value
	 */
	@XmlElement(name = "xCoord")
	private float x;

	/**
	 * Field contains Y coordinate value
	 */
	@XmlElement(name = "yCoord")
	private Integer y;


	/**
	 * Class for creating an instance of Coordinates class
	 */
	public static class CoordinatesBuilder
	{
		/**
		 * Builder X coordinate value
		 */
		private float x;

		/**
		 * Builder Y coordinate value
		 */
		private Integer y;

		/**
		 * Default constructor
		 */
		private CoordinatesBuilder() {}

		/**
		 * X-coordinate setter
		 * @param x x-coord value
		 * @return instance of CoordinatesBuilder class
		 */
		public CoordinatesBuilder setX(float x)
		{
			this.x = x;
			return this;
		}

		/**
		 * Y-coordinates setter
		 * @param y y-coord value
		 * @return instance of CoordinatesBuilder class
		 */
		public CoordinatesBuilder setY(Integer y)
		{
			this.y = y;
			return this;
		}

		/**
		 * Method creates coordinates object
		 * @return Coordinates class instance
		 */
		public Coordinates build()
		{
			return new Coordinates(this);
		}
	}

	/**
	 * Default constructor for marshalling & unmarshalling
	 */
	public Coordinates() {}

	/**
	 * Coordinates class constructor
	 * @param builder is constructor instance with defined values
	 */
	private Coordinates(CoordinatesBuilder builder)
	{
		this.x = builder.x;
		this.y = builder.y;
	}

	/**
	 * X-coordinate getter
	 * @return x-coord value
	 */
	public float getX()
	{
		return x;
	}

	/**
	 * Y-coordinate getter
	 * @return y-coord value
	 */
	public Integer getY()
	{
		return y;
	}

	/**
	 * Method creates string representation of existing coordinates object
	 * @return string representation of coordinates
	 */
	@Override
	public String toString()
	{
		return String.format("Coordinates: (%f, %d)", x, y);
	}

	/**
	 * Method checks current object is equal to specified one
	 * @param obj another coordinates object
	 * @return true if objects are equal, false if they are different
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (!(obj instanceof Coordinates coordinates)) return false;
		if (x != coordinates.x) return false;
		return Objects.equals(y, coordinates.y);
	}

	/**
	 * Generates hashcode for exact object
	 * @return hash code value for exact object
	 */
	@Override
	public int hashCode()
	{
		int result = y != null ? y.hashCode() : 0;
		result = 31 * result + (int) x;
		return result;
	}

	/**
	 * Method that provides you access to CoordinatesBuilder class
	 * @return CoordinatesBuilder class instance
	 */
	public static CoordinatesBuilder builder()
	{
		return new CoordinatesBuilder();
	}

}
