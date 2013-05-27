package assesment.tests.two;

public class Salmon extends Thread {
	public static long id;

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			// insert code here
			// Fragment 1:
			//if (i == 2 && id == Thread.currentThread().getId()) { //Thread-0
			// Fragment 2:
			if(i == 2) {
				new Thread(new Salmon()).start();
				throw new Error();
			}			
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Salmon();
		id = t1.getId();
		t1.start();
		//8.) E.) Regardless of which fragment is inserted, output continues after the Error is thrown.
	}

}
