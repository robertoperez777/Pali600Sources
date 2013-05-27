package Threads;

class FooRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 400; i++) {
			System.out.println("Runnable running: " + i);
			System.out.println("Run by " + Thread.currentThread().getName() + ", i is " + i);
		}
	}

}

public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		FooRunnable r = new FooRunnable();
		FooRunnable r1 = new FooRunnable();
		FooRunnable r2 = new FooRunnable();
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		t.setName("Fred");
		t.setPriority(8);
		t2.setName("Lucy");
		t3.setName("Ricky");
		t.start();
		System.out.println(t.getId() + " " + t.getName());
		t2.start();
		System.out.println(t2.getId() + " " + t.getName());
		t3.start();
		System.out.println(t3.getId() + " " + t.getName());
	}
}
