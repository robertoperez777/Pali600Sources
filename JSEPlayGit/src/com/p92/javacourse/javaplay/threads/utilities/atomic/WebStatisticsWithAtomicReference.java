/**
 * 
 */
package com.p92.javacourse.javaplay.threads.utilities.atomic;

import static com.p92.javacourse.javaplay.utility.Print.print;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;


/**
 * Examples for {@link AtomicReference}
 * 1) Use them when you want to access data atomically.
 * 2) Atomic references have the same memory semantics as volatile variables.
 * 3) It is useful if you have an object that you occasionally want to replace with a new copy.
 * 4) The object should be immutable by design.
 * 5) It is used when you want to update more than one field atomically.
 * 
 * {@link AtomicStampedReference} is similar to {@link AtomicReference} except it 
 * also has an int called initialStamp.  
 * The purpose of the initialStamp is to prevent the situation 
 * where immutable object being referenced goes from A to B and back to A again.  
 * The idea is you pass a unique value as the initialStamp.  
 * If the reference to the immutable object is the same but the initialStamp is different this suggests that A ==> B ==> 
 * A occurred. When A ==> B ==> A occurs the atomic update will fail and it will attempt to do the CAS (compare-and-swap) operation again.
 * 
 * 
 * @author BagyuraI
 */
public class WebStatisticsWithAtomicReference
{
	/** Access statistics for a webapp. */
	private static final class AccessStatistics
	{
		private final int noPages, noErrors;
		public AccessStatistics( int noPages, int noErrors ){ this.noPages=noPages; this.noErrors = noErrors;}
		public int getNoPages() { return noPages; }
		public int getNoErrors() { return noErrors; }
		@Override
		public String toString(){ return "Statistics:[pages: " + noPages + ", errors:" + noErrors + "]"; }
	}
	
	private static final class RequestThread implements Runnable
	{
		private static int ID_GEN = 0;
		private final AtomicReference<AccessStatistics> stats;
		private final int id = ++ID_GEN;
		private final String name = "thread" + id;
		
		public RequestThread( AtomicReference<AccessStatistics> stats ){ this.stats = stats; }
		
		@Override
		public void run()
		{
			AccessStatistics prev, newValue;
			do
			{
				// Random sleep
				try
				{
					Thread.sleep( 5000 );
				} 
				catch (InterruptedException e)
				{
					Thread.currentThread().interrupt();
					throw new RuntimeException(e);
				}
				
				// TODO: NOTE get the atomic object
				// Do not use stats.get().getXYZ because other threads may change the underlying value by
				// setting it to a new variable.
				// TODO: what is the difference?
				prev = stats.get();
				int noPages = prev.getNoPages() + 1;
				int noErrors = prev.getNoErrors();
				if (wasError())
				{
					noErrors++;
				}
				newValue = new AccessStatistics(noPages, noErrors);
				// TODO: NOTE set the atomic object. If the prev is not == with
				// The object held by the AtomicReference then someone has updated the object.
			} while (!stats.compareAndSet(prev, newValue));	
			print( "stats, " + name + " - " + stats );
			
		}
		
		private boolean wasError()
		{
			return new Random().nextInt( 3 ) % 3 == 0;
		}
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		AtomicReference<AccessStatistics> stats = new AtomicReference<AccessStatistics>( new AccessStatistics( 0, 0) );
		for ( int i = 0; i < 10 ; i++ )
		{
			Thread thread = new Thread( new RequestThread( stats ) );
			thread.start();
			thread.join();
		}
		print( "Final stats: " + stats );
	}
	
}
