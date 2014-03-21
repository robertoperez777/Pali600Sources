/**
 * 
 */
package com.p92.javacourse.javaplay.threads.waitandnotify.resourceallocator;

import java.util.Random;

/**
 * A resource allocator thread.
 * It periodically tries to allocate a random number of resources (1-3).
 * @author BagyuraI
 */
public class ResourceAllocator extends Thread
{

	/**
	 * A resources to allocate resources from.
	 */
	private ResourcePool resourcePool;
	/**
	 * Random number generator to generate the number of needed resources.
	 */
	private Random random = new Random();
	
	
	/**
	 * Create a resource allocator thread
	 * @param name Name of the thread
	 * @param resourcePool A resourcePool  to allocate resources from.
	 */
	public ResourceAllocator( String name, ResourcePool resourcePool)
	{
		super( name );
		this.resourcePool = resourcePool;
	}



	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run()
	{
		while ( true )
		{
			// The number of needed resources
			int numberof = 1 + random.nextInt( 3 );
			// Allocate the resources.
			resourcePool.allocateResource( numberof );
			// Sleep 2 sec
			try
			{
				Thread.sleep( 2000 );
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			// Free the resources
			resourcePool.freeResource( numberof );
			// Sleep 2 sec
			try
			{
				Thread.sleep( 2000 );
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
	}
		
	
}
