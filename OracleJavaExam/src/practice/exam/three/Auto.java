package practice.exam.three;

class Engine {
	public class Piston {
		//static Can't be static 
		int count = 0;

		void go() {
			System.out.println(" pump" + ++this.count);
		}
	}

	public Piston getPiston() {
		return new Piston();
	}
}

public class Auto {

	public static void main(String[] args) {
		Engine e = new Engine();
		e.Piston p = e.getPiston();
		p.go();
		p.go();
	}
}
