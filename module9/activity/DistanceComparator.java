package sef.module9.activity;

import java.util.Comparator;

/**
 * Comparator used to compare the distance attributes of two RadarContacts.  If the
 * first parameter is closer than the second, the compare() method will return a negative
 * number.  If the two parameters are of the same distance, it will return 0.  If 
 * the first parameter is farther away than the second, it will return a postive number
 * 
 * @author John Doe
 *
 */
public class DistanceComparator implements Comparator<RadarContact>{

	
	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(RadarContact c1, RadarContact c2) {
		if(c1.getDistance() > c2.getDistance())
			return 1;
		else if(c1.getDistance() < c2.getDistance())
			return -1;
		else
			return 0;
	}
}
