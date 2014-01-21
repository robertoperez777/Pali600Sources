package com.p92.javacourse.javaplay.enums;

import com.p92.javacourse.javaplay.utility.Print;

/**
 * Enum where the constants have a specific method.
 * @author BagyuraI
 */
public enum ConstantSpecifiedMethodEnum
{
	CLASSPATH {
		/* (non-Javadoc)
		 * @see com.p92.javacourse.javaplay.enums.ConstantSpecifiedMethodEnum#getInfo()
		 */
		@Override
		String getInfo()
		{
			return System.getenv( "CLASSPATH" );
		}
	},
	
	VERSION {

		/* (non-Javadoc)
		 * @see com.p92.javacourse.javaplay.enums.ConstantSpecifiedMethodEnum#getInfo()
		 */
		@Override
		String getInfo()
		{
			return System.getProperty( "java.version" );
		}
		
	};
	
	abstract String getInfo();
	
	public static void main(String[] args)
	{
		for ( ConstantSpecifiedMethodEnum e : values() )
		{
			Print.print( e + " - " + e.getInfo() );
		}
	}
}
