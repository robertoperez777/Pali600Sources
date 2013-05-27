package Threads;

public class ManyNames {

	public static void main(String[] args) {
		// Make one Runnable
		NameRunnable nr = new NameRunnable();
		
		Thread one = new Thread(nr);
		one.setName("Fred");
		Thread two = new Thread(nr);
		two.setName("Lucy");
		Thread three = new Thread(nr);
		three.setName("Ricky");
		
		one.start();
		two.start();
		three.start();
	}

}
