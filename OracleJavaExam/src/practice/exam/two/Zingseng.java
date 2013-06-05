package practice.exam.two;

public class Zingseng extends Thread {

	public static void main(String[] args) throws Exception {
		Thread t1 = new Thread(new Zingseng());
		t1.start();
		// insert code here
		for (int i = 0; i < 1000; i++) { //Loop #1
			System.out.print(Thread.currentThread().getName() + " ");
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) { //Loop #2
			System.out.println(Thread.currentThread().getName() + " ");
		}
	}
}
