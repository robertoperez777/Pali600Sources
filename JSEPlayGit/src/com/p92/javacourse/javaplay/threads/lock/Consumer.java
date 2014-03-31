/**
 * 
 */
package com.p92.javacourse.javaplay.threads.lock;

/**
 * Consumer that continuously read from a queue.
 * @author BagyuraI
 */
public class Consumer implements Runnable
{

	/**
	 * The queue to read from.
	 */
	private Queue queue;
	
	/**
	 * Create a consumer that reads the supplied queue.
	 * This will start the consumer thread.
	 * @param queue Queue to read from.
	 */
	public Consumer( Queue queue )
	{
		this.queue = queue;
		// Start the consumer.
		new Thread( this, "Consumer" ).start();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		while ( true )
		{
			try
			{
				// Read the queue.
				queue.take();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}


	
}
