/**
 * 
 */
package com.p92.javacourse.javaplay.threads.waitandnotify.resourceallocator;

/**
 * Application that demonstrates the usage of the wait and notify methods
 * within synchronized blocks. It creates 4 shops that periodically allocates 
 * a random number (1-3) cars. 
 * @author BagyuraI
 */
public class App
{

	/**
	 * Static entry point of the app.
	 * @param args Application arguments. Not used atm.
	 */
	public static void main(String[] args)
	{
		ResourcePool carRental = new ResourcePool( 3 );
		String[] shops = { "Don Pepe", "Budapest Circus", "p92", "Cinema Plaza"  };
		for ( String shop : shops )
		{
			ResourceAllocator resourceAllocator = new ResourceAllocator( shop, carRental );
			resourceAllocator.start();
		}

	}

}
