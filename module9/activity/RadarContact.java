package sef.module9.activity;

/**
 * Interfae for RadarContacts
 * 
 * @author John Doe
 *
 */
public interface RadarContact {
	
	/** 
	 * Sets the ID of this contact
	 * 
	 * @param id id of the contact
	 */
	public void setContactID(String id);
	
	
	/**
	 * Return the contact ID
	 * 
	 * @return the contact ID
	 */
	public String getContactID();
	
	
	/**
	 * The bearing attribute of this contact.  The bearing is represented in degrees
	 * from 0 to 359.99.  A value less than 0 will 'wrap' the bearing value counter clockwise. 
	 * A value greater than 360 will 'wrap' the bearing value clockwise
	 * 
	 * Example#1: A bearing set as 365.0 degrees will set the bearing at 5.0 degrees
	 * Example#2: A bearing set at -10.0 degrees will set the bearing to 350.0 degrees 
	 * 
	 * @param bearing the bearing of this radar contact
	 */
	public void setBearing(double bearing);
	
	
	/**
	 * Sets the distance of this RadarContact.  If the distance is set to less than 0, then
	 * it will set the actual distance to 0
	 * 
	 * @param distance the distance to set
	 */
	public void setDistance(double distance);
	
	/**
	 * Return the bearing of the contact
	 * 
	 * @return the bearing of the contact
	 */
	public double getBearing();
	
	
	/** 
	 * Return the distance of the contact
	 * 
	 * @return the distance of the contact
	 */
	public double getDistance();
	
}
