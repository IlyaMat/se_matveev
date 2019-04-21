package sef.module6.activity;

/**
 * @author John Doe
 * 
 * This interface is a representation of a point in a 2D plane.  The point's
 * location is represented by an {x,y} pair representing the coordinates along the
 * x and y axis.
 */
public interface Point2D {
	
	/**
	 *  Finds the distance between this point object and the passed coordinates (x2,y2) of a second point 
	 * 
	 * @param  x2 is the point coordinate along the x-axis 
	 *         y2 is the point coordinate along the y-axis 
	 *         
	 * @return the calculated distance between the two points as a double
	 */
	public double getDistance(double x2, double y2);
	
	/**
	 *  Finds the distance between this point object and the passed object
	 * 
	 * 
	 * @param p2 is the point within the coordinate
	 * 
	 * @return the calculated distance between the two points as a double
	 */
	public double getDistance(Point2D p2);
	
	/**
	 * Sets the coordinate of the point along the x-axis
	 * 
	 * @param x the coordinate along the x-axis
	 */
	public void setX(double x);
	
	
	/**
	 * Sets the coordinate of the point along the y-axis
	 * 
	 * @param y the coordinate along the y-axis
	 */
	public void setY(double y);
	
	/**
	 * Return the coordinate along the x-axis
	 * 
	 * @return the coordinate of the along the x-axis
	 */
	public double getX();
	
	/**
	 * Return the coordinate along the y-axis
	 * 
	 * @return the coordinate along the y-axis
	 */
	public double getY();
	
	
	/**
	 * Set the location to the coordinates specified by he parameters
	 * 
	 * @param x coordinate of the point along the x-axis
	 * @param y coordinate of the point along the y-axis
	 */
	public void move(double x2, double y2);
	
	/**
	 * Translates the location (x,y) such that the new 
	 * location represented is (x+x2, y+y2)
	 * 
	 * @param x2 the x-axis delta
	 * @param y2 the y-axis delta
	 */
	public void translate(double x2, double y2);
	
	/**
	 * Compares if it is equal to the coordinates specified in the parameter
	 * 
	 * @param x2 coordinate along the x-axis to compare
	 * @param y2 coordinate along the y-axis to compare
	 * 
	 * @return true if the point represented by the parameters is equal to the current point, false otherwise
	 */
	public boolean equals(double x2, double y2);
}
