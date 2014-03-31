/**
 * 
 */
package com.p92.javacourse.javaplay.threads.lock;

/**
 * Producer that puts a value into the queue continuously.
 * @author BagyuraI
 */
public class Producer implements Runnable
{
	/**
	 * Queue to put object into.
	 */
	private Queue queue;
	
	/**
	 * Create a producer that put objects into the supplied queue.
	 * Itt will start the queue thread
	 * @param queue Queue to put object into.
	 */
	public Producer( Queue queue)
	{
		this.queue = queue;
		new Thread( this, "Producer" ).start() ;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		int i = 0;
		while ( true )
		{
			try
			{
				// Put objects into the queue.
				queue.put( new Integer( i++ ) );	
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	
}
