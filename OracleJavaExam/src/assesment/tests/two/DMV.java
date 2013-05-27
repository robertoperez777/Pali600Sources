package assesment.tests.two;

public class DMV implements Runnable {

	public static void main(String... args) {
		DMV d = new DMV();
		Thread t1 = new Thread(d);
		t1.start();
	}
	
	@Override
	public void run() {
		long start = System.currentTimeMillis();
		for (int j = 0; j < 4; j++) {
			do1();
			do2();
		}
		long end = System.currentTimeMillis();
		System.out.println("Execution time: " + (start - end)/1000 );
	}

	void do1() {
		try { 
			Thread.sleep(1000); 
		}catch(Exception e) {
			System.out.println("e ");
		}
	}

	synchronized void do2() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.print("e "); 
		}
	}

	//14.) C. The program’s minimum execution time is about 9 seconds.
}
