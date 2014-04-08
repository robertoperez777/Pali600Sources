/**
 * 
 */
package com.p92.javacourse.javaplay.threads.utilities.executors;

import java.util.concurrent.Executor;

/**
 * A very simple non-asynchronous {@link Executor} implementations.
 * The {@link #execute(Runnable)} method simply calls the passed 
 * command's run() method. The {@link #main(String[])} method 
 * demos the usage of this class with executing an anonymous
 * 'Hello World' printer {@link Runnable}.
 * @author BagyuraI

 */
public class NonAsynchExecutor implements Executor
{

	/* (non-Javadoc)
	 * @see java.util.concurrent.Executor#execute(java.lang.Runnable)
	 */
	@Override
	public void execute(Runnable command)
	{
		command.run();
	}

	/**
	 * Demo the usage of this class with executing an anonymous
	 * Hello World printer {@link Runnable}.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Executor executor = new NonAsynchExecutor();
		executor.execute( new Runnable() {
			@Override
			public void run() { System.out.println( "Hello World!" ); }
		});
	}	
}
