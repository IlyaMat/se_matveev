package sef.module7.activity;

/**
 * An implementation of the Denomination interface.  The equality test for between instances
 * of this class considers the name and the symbol
 * 
 * @author John Doe
 *
 */
public class DenominationImpl implements Denomination {

	
	/**
	 * Creates a new instance with the specified parameters
	 * 
	 * @param name the name of the denomination
	 * @param description a description 
	 * @param symbol
	 */
	private String name;
	private String description;
	private String symbol;

	public DenominationImpl(String name, String description, String symbol) {
		this.name = name;
		this.description = description;
		this.symbol = symbol;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	
	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getName()
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see sef.module6.activity.Denomination#getSymbol()
	 */
	public String getSymbol() {
		return symbol;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/*@Override
	public String toString() {
		return "";
	}*/

	@Override
	public String toString() {
		return "DenominationImpl{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				", symbol='" + symbol + '\'' +
				'}';
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		DenominationImpl denomination = (DenominationImpl) o;
		if(this.name == denomination.name ){
			return true;
		}
		return false;

	}

}
