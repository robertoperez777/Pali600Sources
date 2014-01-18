package practice.exam.three;

public class Stone implements Runnable {

	static int id = 1;

	@Override
	public void run() {
		try {
			id = 1 - id;
			if (id == 0) {
				pick();
			} else {
				release();
			}
		} catch (Exception e) {
		}
	}

	private static void release() throws Exception {
		System.out.print("R ");
		System.out.print("S ");
	}

	private static void pick() throws Exception {
		System.out.print("P ");
		System.out.print("Q ");
	}

	public static void main(String[] args) {
		Stone st = new Stone();
		new Thread(st).start();
		new Thread(st).start();
	}

}

//A.	 The output could be P Q R S
//B.	 The output could be P R S Q
//C.	 The output could be P R Q S
