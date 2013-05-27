package Threads;

public class NameRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				if(i%10 == 0){
					System.out.println("Run by " + Thread.currentThread().getName());
					Thread.currentThread().sleep(1000);
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
