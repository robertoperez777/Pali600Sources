package practice.exam.one;

public class Hug implements Runnable {

	static Thread t1;
	static Hold h, h2;

	public static void main(String[] args) {
		h = new Hold();
		h2 = new Hold();
		t1 = new Thread(new Hug());
		t1.start();
		new Thread(new Hug()).start();
	}

	@Override
	public void run() {
		if (Thread.currentThread().getId() == t1.getId()) {
			h.adjust();
		} else {
			h2.view();
		}
	}

}

class Hold {
	static int x = 5;

	synchronized void adjust() {
		System.out.println(x-- + " ");
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			;
		}
		this.view();
	}

	synchronized void view() {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			;
		}
		if (x > 0) {
			this.adjust();
		}
	}
}

//60.) C.	 The output could be 5 4 3 2 1