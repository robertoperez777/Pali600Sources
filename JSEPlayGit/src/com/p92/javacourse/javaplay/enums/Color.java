/**
 * 
 */
package com.p92.javacourse.javaplay.enums;

/**
 * Enum example with:
 * <ul>
 * 	<li>Constructor</i>
 *  <li>Custom attributes</i>
 *  <li>overridden {@link #compareTo(Color)}  and {@link #toString()} methods.
 *  	Actually compareTo is final so it cannot be overridden.
 *  </li>
 * @author BagyuraI
 */
public enum Color
{
	// Enums
	BLUE( "#0000ff" ,"BLUE" ),
	GREEN( "#006400", "GREEN" );
	
	// Fields
	private final String hex;
	private final String name;
	
	// Constructor
	// Enum constructor is always private
	Color( String hex, String name)
	{
		this.hex = hex;
		this.name = name;
	}
	
	/**
	 * Get the hex attribute
	 * @return
	 */
	public String getHex(){ return this.hex; }
	/**
	 * Get the name attribute
	 * @return
	 */
	public String getName(){ return this.name; }

	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return "Color: " + getName() + ", hex: " + getHex();
	}
	
	
	
	
}
