package com.p92.javacourse.javaplay.enums;

import static com.p92.javacourse.javaplay.utility.Print.print;

import java.util.EnumMap;
import java.util.Map;

/**
 * Example usage of {@link EnumMap}.
 * @author BagyuraI
 */
public class EnumMapPlay
{
	static interface Command
	{
		void action();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// Define an empty map
		EnumMap<AlarmPoints,Command> em = new EnumMap<AlarmPoints,Command>( AlarmPoints.class );
		
		
		// Put some alert - action into the map.
		em.put( AlarmPoints.KITCHEN, new Command()
		{
			@Override
			public void action()
			{
				print( "The kitchen is in fire. Call 105!");
			}
		});
		
		em.put( AlarmPoints.BATHROOM , new Command()
		{
			@Override
			public void action()
			{
				print( "Overflow. Call the housekeeper!" );
			}
		});
		
		// Trigger the actions.
		for ( Map.Entry<AlarmPoints,Command> e : em.entrySet() )
		{
			print( "Trouble in " + e.getKey() + ". Execution the command" );
			e.getValue().action();
			
		}
		
	}

}
