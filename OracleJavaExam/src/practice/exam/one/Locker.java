package practice.exam.one;

public class Locker extends Thread {

	private static Thread t;

	@Override
	public void run() {
		if (Thread.currentThread() == t) {
			//System.out.println(Thread.currentThread().getName());
			System.out.println("1 ");
			synchronized (t) {
				this.doSleep(2000);
			}
			System.out.println("2 ");
		} else {
			System.out.println("3 ");
			synchronized (t) {
				this.doSleep(1000);
			}
			System.out.println("4 ");
		}
		//42.) E. The output could be 1 3 2 4
	}

	private void doSleep(int delay) {
		try {
			Thread.sleep(delay);
		} catch (InterruptedException ie) {
			;
		}
	}

	public static void main(String[] args) {
		t = new Locker();
		t.start();
		new Locker().start();
	}

}
