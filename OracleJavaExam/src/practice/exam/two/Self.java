package practice.exam.two;

public class Self extends Thread {

	public static void main(String[] args) {
		try {
			Thread t = new Thread(new Self());
			t.start();
			t.start();
		} catch (Exception e) {
			System.out.println("e ");
		}
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName() + " ");
		}
	}
}

/* 5.)
 	C.	 The output could be Thread-1 Thread-1 e
 */
