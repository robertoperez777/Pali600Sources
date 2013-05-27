package assesment.tests.one;

public class Fabric extends Thread {
	public static void main(String[] args) {
		Thread t = new Thread(new Fabric());
		Thread t2 = new Thread(new Fabric());
		t.start();
		t2.start();
	}
	
	@Override
	public stitic void run() { //Compile error
		for (int i = 0; i < 2; i++) {
			System.out.print(Thread.currentThread().getName() + " ");
		}
	}
	// 3.) A
}
