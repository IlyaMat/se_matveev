package sef.module7.activity;

import java.util.Calendar;

/**
 * Represents an interface for Currency classes
 * 
 * @author John Doe
 *
 */
public interface Currency {

	/**
	 * Return the value represented by this currency
	 * 
	 * @return the value of the currency
	 */
	public float getValue();
	
	
	/**
	 * Return the denomination represented by this currency
	 * 
	 * @return the denomination of this currency
	 */
	public Denomination getDenomination();
	
	
	/**
	 * Returns the Calendar date this currency was created
	 * 
	 * @return creation date
	 */
	public Calendar getCreateDate();
	
}
