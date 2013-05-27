package Threads;

public class AccountDanger implements Runnable {

	private Account acct = new Account();
	
	public static void main(String[] args) {
		AccountDanger r = new AccountDanger();
		Thread one = new Thread(r);
		one.setName("Fred");
		Thread two = new Thread(r);
		two.setName("Lucy");
		one.start();
		two.start();
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			makeWithDrawal(10);
			if(acct.getBalance() < 0){
				System.out.println("account is overdrawn!");
			}
		}
	}

	private synchronized void makeWithDrawal(int amt) {
		if(acct.getBalance() >= amt){
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try {
				Thread.sleep(500);
			} catch (InterruptedException ex) {
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
		} else {
			System.out.println("Not enough in account for " 
					+ Thread.currentThread().getName() + " to withdraw " + acct.getBalance());
		}
	}

}
