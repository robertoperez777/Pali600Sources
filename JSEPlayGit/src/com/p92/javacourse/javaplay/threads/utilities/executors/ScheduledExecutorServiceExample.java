/**
 * 
 */
package com.p92.javacourse.javaplay.threads.utilities.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Example app. for the usage of the {@link ScheduledExecutorService}.
 * It starts a task periodically, executing it in every 2 seconds.
 * Then it starts a second task that will cancel this periodic task after 10 sec of execution.
 * 
 * @author BagyuraI
 */
public class ScheduledExecutorServiceExample
{

	
	
	/**
	 * Starts the app.
	 * @param args Program arguments. They are not used atm.
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		
		// ExecutorService that can schedule commands to run after a given delay 
		// or to execute them periodically
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool( 2 );
		
		// Execute a task periodically every 2 seconds.
		Runnable task1 = new Runnable()
		{
			@Override
			public void run()
			{
				System.out.println( "Executing command..." );
				
			}
		};
		final ScheduledFuture<?> task1Handler = scheduler.scheduleAtFixedRate( task1, 0, 2, TimeUnit.SECONDS );
		
		
		// Schedule a task to cancel our periodic task after 10 seconds
		Runnable cancelTask1Task = new Runnable()
		{
			
			@Override
			public void run()
			{
				task1Handler.cancel( true );
				System.out.println( "Cancelling task1." );
			}
		};
		
		
		
		final ScheduledFuture<?> cancelTaskHandler = scheduler.schedule( cancelTask1Task, 10, TimeUnit.SECONDS );
		cancelTaskHandler.get();
		System.out.println( "Task1.isDone: " + task1Handler.isDone() + ", Task1.isCancelled: " + task1Handler.isCancelled() );
		
		
	}

}
