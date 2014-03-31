/**
 * 
 */
package com.p92.javacourse.javaplay.threads.utilities.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * An ATM simultation where we have {@link ATMUser} objects as one shot threads
 * which withdraw some money from a shared {@link Account}.
 * This shared {@link Account} protects it's balance with an {@link AtomicReferenceFieldUpdater}. So it is thread-safe. 
 * It utilize the {@link AtomicReferenceFieldUpdater#compareAndSet(Object, Object, Object)} method in the {@link Account#withdraw(Long)}.
 * This way withdrawing some money is volatile and atomic
 * @author BagyuraI
 *
 */
public class ATMWithAtomicUpdater
{
	/**
	 * A thread-safe account that can be shared among users.
	 * It has a {@link Account#balance} that keeps track of the money on the account.
	 * It provides a {@link Account#withdraw(Long)} method to withdraw a certain amount from the
	 * account. The invariance is that a balance cannot be negative. The withdraw method utilize
	 * the  {@link AtomicReferenceFieldUpdater#compareAndSet(Object, Object, Object)} method to be 
	 * volatile and atomic.
	 * @author BagyuraI
	 *
	 */
	private static class Account
	{
		/**
		 * Balance of the account.
		 * NOTE: it must be volatile
		 */
		private volatile Long balance;
		
		/**
		 * Atomic updater for the {@link #balance}
		 */
		private static final AtomicReferenceFieldUpdater<Account, Long> balanceUpdater 
			= AtomicReferenceFieldUpdater.newUpdater( Account.class, Long.class, "balance" );
		
		/**
		 * Creates an account with it's initial balance.
		 * @param balance Initial balance
		 */
		public Account(long balance)
		{
			super();
			this.balance = balance;
		}

		/**
		 * Withdraw a certain amount from the
	     * account. The invariance is that a balance cannot be negative. The withdraw method utilize
	     * the  {@link AtomicReferenceFieldUpdater#compareAndSet(Object, Object, Object)} method to be 
	     * volatile and atomic. The balance cannot be negative. After the balance invariance chek it sleeps for
	     * 5000 millisec for demonstration purposes.
		 * @param balance the balance to set
		 * @return {@code TRUE} if the withdraw is successful.
		 */
		public boolean withdraw(Long amount)
		{
			Long prevBalance = null, newBalance = null;
			do
			{
				prevBalance = balanceUpdater.get( this );
				if ( prevBalance - amount >= 0 )
				{
					// Sleep for some sec.
					// This way the fields can mess up the balance. 
					try
					{
						Thread.sleep( 5000 );
					} 
					catch (InterruptedException e)
					{
						
						Thread.currentThread().interrupt();
						throw new RuntimeException( e );
					}	
					
					newBalance = prevBalance - amount;
					System.out.println( Thread.currentThread().getName() +  "tries to withdraw " + amount + ". New balance would be: " + newBalance );
				}
				else 
				{
					// Not enough money
					System.out.println( Thread.currentThread().getName() +  "cannot withdraw " + amount + ". Act balance: " + prevBalance );
					return false;
				}
			} 
			while ( !balanceUpdater.compareAndSet( this, prevBalance, newBalance) );
			
			
			// withdraw is successful.
			return true;
		}
		
		

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString()
		{
			return "Account [balance=" + balance + "]";
		}
		
	}
	
	/**
	 * An ATM user that uses an {@link Account} to withdraw 100 money.
	 * The {@link Account} is taking care of it's thread safety.
	 * @author BagyuraI
	 */
	private static class ATMUser implements Runnable
	{
		/** 
		 * Account to work with. It will be shared in the example. 
		 */
		private Account account; 
		
		/** 
		 * Creates an ATMUser
		 * @param account The account. It will be shared in the example.
		 */
		public ATMUser(Account account)
		{
			super();
			this.account = account;
		}


		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()
		{
			System.out.println( Thread.currentThread().getName() + "withdrawing 100: " + account.withdraw( new Long(100) ) );	
		}
		
	}

	/**
	 * It creates an {@link Account} with 350 money, then starts 10 {@link ATMUser} threads.
	 * They shares the account and they try to withdraw 100 money. 
	 * @param args Command line arguments. They are not used at this moment.
	 */
	public static void main(String[] args)
	{
		Account acc = new Account( 350 );
		for ( int i = 0; i < 10; i++ )
			new Thread( new ATMUser( acc ) ).start();
	}
	
}
