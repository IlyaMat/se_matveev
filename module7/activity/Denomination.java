package sef.module7.activity;

/**
 * An interface representing denominations used by various currencies
 * 
 * @author John Doe
 *
 */
public interface Denomination {

	/**
	 * Return the description of this denomination
	 * 
	 * @return the description
	 */
	public String getDescription();
	
	
	/**
	 * Return the name of this denomination
	 * 
	 * @return the name 
	 */
	public String getName();
	
	
	/**
	 * Returns the symbol associated with this denomination
	 * 
	 * @return the symbol
	 */
	public String getSymbol();
	
}
