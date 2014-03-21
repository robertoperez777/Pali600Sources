/**
 * 
 */
package com.p92.javacourse.javaplay.threads.synch;

/**
 * A banking example without synchronization.
 * Two person tries to use the same account. The result is disastrous for the bank
 * (and for the programmer).
 * @author BagyuraI
 */
public class BankingExampleWithoutSynch
{
	
	
	/**
	 * Automated teller machine
	 */
	private static class ATM
	{
		/**
		 * Account to withdraw cash from.
		 */
		private Account acc;
		/**
		 * Name of the current thread that uses the ATM.
		 * It is used for debugging.
		 */
		private String thread = Thread.currentThread().getName();
		/**
		 * Sleep in millis we wait between the assertion of eligibility of the withdraw attempt and
		 * the actual withdraw. This helps us to show the possible synchronization fault in our program.
		 */
		private long sleepMillis;
		
		/**
		 * Creates an ATM.
		 * @param acc Account to withdraw cash from.
		 * @param sleepMillis Sleep in millis we wait between the assertion of eligibility of the withdraw attempt and
		 * 					  the actual withdraw. This helps us to show the possible synchronization fault in our program.
		 */
		public ATM( Account acc, long sleepMillis )
		{
			this.acc = acc;
			this.sleepMillis = sleepMillis;
		}
		
		/**
		 * Withdraw cash from the atm.
		 * @param amount Amount to withdraw.
		 */
		public void withdraw( float amount )
		{
			
			if ( acc.deduct(amount,sleepMillis) )
				dispense(amount);
			printReceipt(acc.getTotal());
		}
		
		/**
		 * Dispense the cash.
		 * @param amount Amount to dispense
		 */
		private void dispense( float amount )
		{
			System.out.println( thread + " dispense: " + amount );
		}
		
		/**
		 * Print the total amount remained on the account.
		 * @param total total amount of money on the account.
		 */
		private void printReceipt( float total )
		{
			System.out.println( thread + " total: " + total );
		}
	}
	
	
	/**
	 * Account
	 * @author BagyuraI
	 */
	private static class Account
	{
		/**
		 * The total amount of money on the account.
		 */
		private float total;
		
		/**
		 * Creates an account.
		 * @param total The total amount of money on the account.
		 */
		public Account( float total)
		{
			this.total = total;
		}
		
		/**
		 * Deduct some money from the account.
		 * @param amount amount of money to deduct
		 * @param sleepMillis Sleep in millis we wait between the assertion of eligibility of withdraw and
		 * 					  the actual withdraw. This helps us to show the possible synchronization fault of our program.
		 * @return {@code TRUE} the deduct happened.
		 */
		public boolean deduct( float amount, long sleepMillis)
		{
			String thread = Thread.currentThread().getName();
			System.out.println( thread + " tries to deduct " + amount  );
			
			
			if ( amount <= total )
			{
				System.out.println( thread + " eligible to deduct " +amount  );
				System.out.println( thread + " sleeping " + sleepMillis  );
				BankingExampleWithoutSynch.sleep( sleepMillis );
				total -= amount;
				System.out.println( thread + " deducted " + amount  );
				return true;
			}
			System.out.println( thread + " couldn't deduct " +amount  );
			return false;
		}
		
		/**
		 * @return the total
		 */
		public float getTotal()
		{
			return total;
		}

	}

	/**
	 * Helper method to sleep for a certain milliseconds
	 * @param millis Number of milliseconds to sleep.
	 */
	private static void sleep( long millis )
	{
		try
		{
			Thread.sleep( millis );
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * A thread that can withdraw money from an account.
	 */
	private static class WithdrawThread extends Thread
	{
		/**
		 * Account to withdraw from.
		 */
		private Account acc;
		/**
		 * Amount to withdraw.
		 */
		private int amount;
		/**
		 * Sleep in millis we wait between the assertion of eligibility of withdraw and
		 * the actual withdraw. This helps us to show the possible synchronization fault of our program.
		 */
		private long sleepMillis;
		
		/**
		 * Creates a WithdrawThread
		 * @param acc ccount to withdraw from.
		 * @param name Name of the thread. It is used for debugging.
		 * @param amount Amount to withdraw.
		 * @param sleepMillis Sleep in millis we wait between the assertion of eligibility of withdraw and
		 * 					  the actual withdraw. This helps us to show the possible synchronization fault of our program.
		 */
		public WithdrawThread( Account acc, String name, int amount, long sleepMillis)
		{
			super( name );
			this.acc = acc;
			this.amount = amount;
			this.sleepMillis = sleepMillis;
		}
		
		/* (non-Javadoc)
		 * @see java.lang.Thread#run()
		 */
		@Override
		public void run()
		{
			ATM atm = new ATM( acc, sleepMillis );
			atm.withdraw( amount );
		}
		
	}
	
	/**
	 * Static entry point of the app.
	 * @param args Application arguments. Not used atm.
	 */
	public static void main(String[] args)
	{
		// Create a shared account with 60 money.
		Account acc = new Account( 60 );
		
		// Jozsi tries to withdraw 45 money.
		WithdrawThread withdraw1 = new WithdrawThread(acc, "Jozsi", 45 , 1000 );
		withdraw1.start();
		
		// Gabor tries to withdraw 45 money.
		WithdrawThread withdraw2 = new WithdrawThread(acc, "Gabor", 45 , 1 );
		withdraw2.start();

	}

}
