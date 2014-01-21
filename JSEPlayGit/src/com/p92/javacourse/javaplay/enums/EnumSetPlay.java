package com.p92.javacourse.javaplay.enums;

import java.util.EnumSet;
import static com.p92.javacourse.javaplay.utility.Print.*;

/**
 * Example usage of {@link EnumSet}.
 * @author BagyuraI
 */
public class EnumSetPlay
{

	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Define an empty set.
		EnumSet<AlarmPoints> points = EnumSet.noneOf( AlarmPoints.class );
		
		points.add( AlarmPoints.BATHROOM );
		print( points );

		points.addAll( EnumSet.of( AlarmPoints.KITCHEN, AlarmPoints.LOBBY ) );
		print( points );
		
		points = EnumSet.allOf( AlarmPoints.class );
		print( points );
		
		points.removeAll( EnumSet.range( AlarmPoints.STARIR1, AlarmPoints.KITCHEN)) ;
		print( points );
		
		points = EnumSet.complementOf( points );
		print( points );
	}

}
