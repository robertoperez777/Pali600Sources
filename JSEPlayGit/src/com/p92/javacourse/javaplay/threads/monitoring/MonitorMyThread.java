/**
 * 
 */
package com.p92.javacourse.javaplay.threads.monitoring;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Date;
import java.util.Random;

/**
 * Example program for using the {@link ThreadMXBean} to monitor the a user
 * started thread called <i>HelloProcess</i>. This thread is sleeping 100 millis for every 10000 millis.
 * The main thread will take a look at the thread info of the thread in every 1000 millis and prints 
 * out the info of this thread.
 * @author BagyuraI
 *
 */
public class MonitorMyThread
{

	
	/**
	 * A simple process that runs in an infinite loop and in every 10000 millis
	 * sleeps for 100 millis.
	 * @author BagyuraI
	 */
	private static class HelloProcess implements Runnable
	{

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()
		{
			Date start = new Date();
			while ( true )
			{
				try
				{
					if ( (System.currentTimeMillis() - start.getTime()) % 10000 == 0 )
					{
						Thread.sleep( new Random().nextInt( 100 ) );
					}
				}
				catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
					throw new RuntimeException( "HelloProcess interrupted" );
				}
			}
		}
	}
	
	
	
	
	
	
	/**
	 * Static entry point of this program.
	 * @param args Program arguments. Not used atm.
	 */
	public static void main(String[] args)
	{
		
		Thread thread = new Thread( new HelloProcess(), "HelloProcess" );
		thread.start();
		
		while ( true )
		{
			try
			{
				Thread.sleep( 1000 );
				ThreadMXBean threadMX = ManagementFactory.getThreadMXBean();
				ThreadInfo threadInfo = threadMX.getThreadInfo( thread.getId() , 15);
				System.out.println( threadInfo );
			}
			catch (InterruptedException e)
			{
				System.exit(0);
			}
			
		}

		

		
	}

}
