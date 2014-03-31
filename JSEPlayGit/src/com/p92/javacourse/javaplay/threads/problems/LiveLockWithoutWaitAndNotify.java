/**
 * 
 */
package com.p92.javacourse.javaplay.threads.problems;

/**
 * Live lock example from http://stackoverflow.com/questions/1036364/good-example-of-livelock.
 * It demos a young couple who have only one spoon. They are both polite so the spoon owner will
 * pass the spoon to the other if the other is still hungry. There is a problem if both are still
 * hungry. The spoon will go around endlessly.
 * 
 * 
 * @author BagyuraI
 *
 */
public class LiveLockWithoutWaitAndNotify
{
	private static class Spoon
	{
		private Diner owner;
		
		public Spoon( Diner owner ) { this.owner = owner; }
		
		public void use() { System.out.println( owner.name + " is eating" );} 
	}
	
	private static class Diner
	{
		private String name;
		
		private boolean hungry;
		
		public Diner( String name ){ this.name = name; hungry = true;}
		
		public boolean isHungry(){ return hungry; };
		
		public void eathWith( Spoon spoon, Diner spouse )
		{
			while ( isHungry() )
			{
				// Do not have the spoon. Wait for the spouse.
				if ( spoon.owner != this )
				{
					try{ Thread.sleep( 1000 ); } catch ( InterruptedException iex ){ continue; }
					System.out.println( name + " does not have the spoon. Wait for the spouse." );
					continue;
				}
				
				// I have the spoon but the spouse is hungry. I will pass the spoon
				if ( spouse.isHungry() )
				{
					spoon.owner = spouse;
					System.out.println( name + " has the spoon but the spouse is hungry. Passing the spoon to " + spouse.name );
					continue;
				}
				
				spoon.use();
				hungry = false;
				System.out.println( name + " is not hungry anymore" );
				spoon.owner = spouse;

			}
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		final Diner husband = new Diner( "Spongya Bob" );
		final Diner wife = new Diner( "Hello Kitty" );
		final Spoon spoon = new Spoon( husband );
		
		new Thread( new Runnable(){ 
			
			@Override
			public void run()
			{
				husband.eathWith(spoon, wife);
			}
			
		}).start();
		
		new Thread( new Runnable(){ 
			
			@Override
			public void run()
			{
				wife.eathWith(spoon, husband);
			}
			
		}).start();
		
	}

}
