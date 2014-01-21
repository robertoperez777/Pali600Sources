/**
 * 
 */
package com.p92.javacourse.javaplay.enums;


/**
 * Enum demonstration.
 * @author BagyuraI
 */
public class EnumPlay
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		// Iterating through the colors
		for ( Color c : Color.values() )
			System.out.println( c );
	
		// Usage with switch
		Color myColor = Color.BLUE;
		switch (myColor)
		{
			case BLUE: 
				System.out.println( "My color is blue." );
				break;
			default:
				break;
		}
		
		// String to enum
		Color color = Color.valueOf( "BLUE" );
		System.out.println( color );
		
	}

}
