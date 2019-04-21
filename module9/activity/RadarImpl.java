package sef.module9.activity;

import sef.module15.activity.Permission;
import sef.module6.sample.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of a Radar 
 * 
 *
 */
public class RadarImpl implements Radar{



	/**
	 *  Constructs a new Radar 
	 */
	private List<RadarContact> radarContactList;

	public RadarImpl(){
		radarContactList = new ArrayList<>();
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
	 */
	public RadarContact addContact(RadarContact contact) {
	    if(contact == null){
	        return null;
        }
        for(int i=0;i<radarContactList.size();i++){
            if(radarContactList.get(i).getContactID() == contact.getContactID()){
                radarContactList.remove(i);
                radarContactList.add(i,contact);
                return contact;
            }
        }
        radarContactList.add(contact);
        return contact;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContact(java.lang.String)
	 */
	public RadarContact getContact(String id) {
			for (int i = 0; i < radarContactList.size(); i++) {
				if (radarContactList.get(i).getContactID().equals(id)) {
					return radarContactList.get(i);
				}
			}
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContactCount()
	 */
	public int getContactCount() {
		return radarContactList.size();
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#removeContact(java.lang.String)
	 */
	public RadarContact removeContact(String id) {
		for(int i=0;i<radarContactList.size();i++){
		    if(radarContactList.get(i).getContactID().equals(id)){
		       return radarContactList.remove(i);
            }
        }
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts()
	 */
	public List<RadarContact> returnContacts() {
        List<RadarContact> list = new ArrayList<>(radarContactList);
        return list;
        //return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
	 */
	public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
    	//return Collections.sort(radarContactList, new DistanceComparator());
    	 Collections.sort(this.radarContactList,comparator);
    	 return returnContacts();
	}

	
}
