/**
 * 
 */
package com.p92.javacourse.javaplay.threads.monitoring;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.Date;

import com.p92.javacourse.javaplay.utility.Print;

/**
 * It is a thread that prints thread info of the JVM on to the default 
 * output. The interval time between each print is {@value #PROFILE_INTERVAL} millis.
 * It can include {@value #MAX_STACK_TRACE_DEPTH} entries in the stack trace to be dumped.
 * Run the {@link #main(String[])} method to demonstrate it's usage.
 * 
 * @author BagyuraI
 *
 */
public class JvmProiler implements Runnable
{
	/** Interval between two profiling in millis */
	private static final int PROFILE_INTERVAL = 1000;
	/** Entries in the stack trace to be dumped */
	private static final int MAX_STACK_TRACE_DEPTH = 3;
	/** Thread management bean. */
	private ThreadMXBean threadMx = ManagementFactory.getThreadMXBean();
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		try
		{
			while ( !Thread.currentThread().isInterrupted() )
			{
				printProfilingHeader();
				
				for ( ThreadInfo threadInfo : getThreadInfos() )
				{
					printThreadInfo( threadInfo );
				}
				
				Thread.sleep( PROFILE_INTERVAL );
			}
		}
		catch( InterruptedException iex )
		{
			throw new RuntimeException( "JvmProfiler interrupted", iex );
		}
		
	}
	
	/**
	 * Returns with all alive threads at the moment of the call of this method. 
	 * @return all alive threads at the moment of the call of this method.
	 */
	private ThreadInfo[] getThreadInfos()
	{
		return threadMx.getThreadInfo( threadMx.getAllThreadIds(),
										MAX_STACK_TRACE_DEPTH);
	}
	
	/**
	 * Prints useful info about the passed thread.
	 * @param info Thread about which we print info to the default output.
	 */
	private void printThreadInfo( ThreadInfo info )
	{
		Print.print( info );
	}
	
	/**
	 * Prints the profiling starts message on to the default out.
	 */
	private void printProfilingHeader()
	{
		System.out.println( "============================= Profiling Starts: " + new Date() + "================================" );
	}
	
	
	/**
	 * Starts 10 threads and a profiler thread.
	 * @param args Command line arguments. They are not used atm.
	 */
	public static void main(String[] args)
	{
		Thread profilerThread = new Thread( new JvmProiler() );
		profilerThread.start();
		
		for ( int i = 0 ; i < 10; i++ )
		{
			new Thread( new Runnable()
			{
				@Override
				public void run()
				{
					System.out.println( "Thread started: "  + Thread.currentThread().getName() );
					try
					{
						Thread.sleep( 10000 );
					}
					catch (InterruptedException e)
					{
						Thread.currentThread().interrupt();
					}
				}
			}).start();;
		}
		
	}
}
