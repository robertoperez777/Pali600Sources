package practice.exam.two;

class MotorVehicle {
	protected int doStuff(int x) {
		return x * 2;
	}
}

class Bicycle {
	void go(MotorVehicle m) {
		System.out.println(m.doStuff(21) + " ");
	}
}

public class Beemer extends MotorVehicle {
	public static void main(String[] args) {
		System.out.print(new Beemer().doStuff(11) + " ");
		new Bicycle().go(new Beemer());
		new Bicycle().go(new MotorVehicle());
	}

	@Override
	int doStuff(int x) {
		return x * 3;
		//Cannot reduce the visibility of the inherited method from 
		//MotorVehicle
	}
}

/* 
 	20.) E.	 Compilation fails.
*/

*/