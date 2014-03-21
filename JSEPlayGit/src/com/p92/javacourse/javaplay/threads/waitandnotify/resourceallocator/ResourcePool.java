/**
 * 
 */
package com.p92.javacourse.javaplay.threads.waitandnotify.resourceallocator;

/**
 * A class that keep tracks of available resources.
 * It has 2 methods for working with the resources, one for allocating resources, one for 
 * releasing them. The {@link #allocateResource(int)} allocates resources. If there is not 
 * enough resources it will wait. The {@link #freeResource(int)} give the resources back
 * and notifies the threads that are waiting for resources.
 * @author BagyuraI
 */
public class ResourcePool
{
	/**
	 * Number of allocated resources.
	 */
	private int resourcecount = 0;
	/**
	 * Maximum number of available resources.
	 */
	private int resourcemax = 0;
	
	/**
	 * Create a pool of resources.
	 * @param resourcemax Maximum number of available resources.
	 */
	public ResourcePool( int resourcemax )
	{
		this.resourcemax = resourcemax;
	}
	
	/**
	 * Allocate a certain number of resources.
	 * If this number cannot be allocated it will wait until there will be 
	 * enough resources.
	 * @param numberof The number of needed resources.
	 */
	public synchronized void allocateResource( int numberof )
	{
		String thread = Thread.currentThread().getName() ;
		while ( true )
		{
			System.out.println( thread + " tries to allocate " + numberof + " res." );
			// Check if there are enough resources.
			if ( resourcecount + numberof <= resourcemax )
			{
				// There are enough resources. Get them.
				System.out.println( thread + " allocated " + numberof + " res." );
				resourcecount += numberof;
				break;
			}
			System.out.println( thread + " couldn't allocate " + numberof + " res." );
			System.out.println( thread + " waits." );
			// There are not enough resources.
			// Wait for them.
			try 
			{ 
				wait(); 
			}
			catch( InterruptedException ex ) 
			{ 
				ex.printStackTrace();
			};
			
		}
	}
	
	/**
	 * Gives the number of resources back.
	 */
	public synchronized void freeResource( int numberof )
	{
		String thread = Thread.currentThread().getName() ;
		System.out.println( thread + " freed " + numberof + " res." );
		// Put the resources back to the pool.
		resourcecount -= numberof;
		// Notify all waiting thread.
		notifyAll();
	}
	
	
}
