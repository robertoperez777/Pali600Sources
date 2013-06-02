package practice.exam.one;

import practice.exam.one.Watch.Workings;

interface Gadget {

}

class Watch {
	class Workings implements Gadget {
		Workings()
		/*insert code here*/
		{
			System.out.print("1 ");
		}

		void tick()
		/*insert code here*/
		{
			System.out.print("3 ");
		}
		//insert code here	//insert code here		
	}

	/*insert code here*/void tock() /*insert code here*/
	{
		System.out.print("2 ");
	}
}

public class Timer {
	public static void main(String[] args) {
		Watch w = new Watch();
		/*insert code:*/Workings ww = w.new Workings();
		/*insert code*/ww.tick();
	}
}

//"1 3 2 3 2 "
