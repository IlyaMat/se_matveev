package sef.module9.activity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Implementation of a RadarContact
 * 
 * @author John Doe
 *
 */
public class RadarContactImpl implements RadarContact {


	/**
	 * Creates a RadarContact with the specified ID, bearing and distance.  
	 * 
	 * @param contactID the contact's ID
	 * @param bearing the contact's bearing
	 * @param distance the contact's distance
	 */

	private String contactID;
	private double bearing;
	private double distance;

	public RadarContactImpl(String contactID, double bearing, double distance){
		/*this.contactID = contactID;
		this.bearing = bearing;
		this.distance = distance;*/
		setContactID(contactID);
		setBearing(bearing);
		setDistance(distance);
	}
	

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getBearing()
	 */
	public final double getBearing() {
		bearing  = new BigDecimal(bearing).setScale(1, RoundingMode.DOWN).doubleValue();
		return bearing;
	}
	

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setBearing(double)
	 */
	public final void setBearing(double bearing) {
		if(bearing < 0){
			while (bearing < 0){
				bearing += 360;//359.99;
				if(bearing > 0 && bearing < 359.99){
					this.bearing = bearing;
					return;
				}
			}
		}
		 else if(bearing >= 360){
			while (bearing > 359.99){
				bearing -= 359.99;//360;
				if(bearing > 0 && bearing < 359.99){
					this.bearing = bearing;
					return;
				}
			}
		}
		else {
			this.bearing = bearing;
		}
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getDistance()
	 */
	public final double getDistance() {
		return distance;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setDistance(double)
	 */
	public final void setDistance(double distance) {
		if(distance<0){
			this.distance = 0;
		}
		else {
			this.distance = distance;
		}
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#getContactID()
	 */
	public final String getContactID() {
		return contactID;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.RadarContact#setContactID(java.lang.String)
	 */
	public final void setContactID(String contactID) {
		this.contactID = contactID;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

	public String toString() {
		return "RadarContactImpl{" +
				"contactID='" + contactID + '\'' +
				", bearing=" + bearing +
				", distance=" + distance +
				'}';
		//return "";
	}
}
