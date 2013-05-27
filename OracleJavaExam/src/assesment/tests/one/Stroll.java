package assesment.tests.one;

class Mosey implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getId() + "-" + i + " ");
		}
	}

}
public class Stroll {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Mosey());
		//Insert code here
		//A.
		t1.setPriority(1);
		new Mosey().run();
		t1.start();
		//B.
		/*
		t1.setPriority(9);
		new Mosey().run();
		t1.start();
		*/
		//C.
		/*
		t1.setPriority(1);
		t1.start();
		new Mosey().run();
		*/
		//D.
		/*
		t1.setPriority(8);
		t1.start();
		new Mosey().run();
		*/
	}
}


/* 13.)
		boolean b = false;
		int i = 7;
		double d = 1.23;
		float f = 4.56f;
		// insert code here
		A.	 System.out.printf(" %b", b);
		D.	 System.out.format(" %d", i);
 		E.	 System.out.format(" %f", f);



*/