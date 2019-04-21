package sef.module9.activity;

import java.util.Comparator;
import java.util.List;

/**
 * Interface representing the behavior of a Radar 
 *
 */
public interface Radar {

	/**
	 * Adds a RadarContact to the Radar's list of contacts.  Each contact is unique
	 * according to the RadarContact.getContactID().  If another contact is added with the 
	 * same ID, it will replace the attributes of the existing contact with the specified
	 * contact.
	 * 
	 * Null parameters are ignored and not added
	 * 
	 * @param contact the RadarContact to be added
	 * 
	 * @return A reference of the actual RadarContact object added to the contact list
	 */
	public RadarContact addContact(RadarContact contact);
	
	
	/**
	 * Removes the specified contact from the contact list with the specified contactID
	 * This method will return null if the contactID is not listed 
	 * 
	 * @param id the id of the RadarContact to remove
	 * 
	 * @return reference to the RadarContact object removed from the list
	 */
	public RadarContact removeContact(String id);
	
	
	/**
	 * Returns a reference to the RadarContact specified by the parameter.  This
	 * method will return null if the id is not listed
	 * 
	 * @param id the id of the RadarContact to find
	 * 
	 * @return
	 */
	public RadarContact getContact(String id);
	
	
	
	/**
	 * Returns the number of RadarContacts tracked by this Radar
	 * 
	 * @return the count of RadarContacts
	 */
	public int getContactCount();
	
	
	/**
	 * Returns a List of RadarContacts tracked by this Radar.  The order of the list
	 * depends on the current Radar implementation
	 * 
	 * @return List of RadarContacts
	 */
	public List<RadarContact> returnContacts();
	
	
	/**
	 * Returns a list of RadarContacts tracked by this Radar, ordered by the Comparator used
	 * 
	 * @param comparator Comparator to be used
	 * @return ordered List of RadarContacts
	 */
	public List<RadarContact> returnContacts(Comparator<RadarContact> comparator);
	
}
