package com.megateam.dao.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * JAXB LocalDateTime adapter
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>
{
	/**
	 * JAXB LocalDateTimeAdapter unmarshal method
	 * @param v The value to be converted. Can be null.
	 * @return if passed parameter is not null or empty string returns LocalDateTime obj,
	 * otherwise returns now LocalDateTime object
	 */
	@Override
	public LocalDateTime unmarshal(String v)
	{
		if (v == null || "".equals(v))
			return LocalDateTime.now(ZoneId.systemDefault());

		return LocalDateTime.parse(v);
	}

	/**
	 * JAXB LocalDateTimeAdapter marshal method
	 * @param v The value to be converted. Can be null.
	 * @return if passed parameter is not null returns LocalDateTime string representation,
	 * otherwise returns now LocalDateTime object's representation
	 */
	@Override
	public String marshal(LocalDateTime v)
	{
		if (v == null)
			return LocalDateTime.now(ZoneId.systemDefault()).toString();

		return v.toString();
	}
}
