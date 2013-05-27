package assesment.tests.one;

public class RediMix extends Concrete {
	RediMix() {
		System.out.println("r ");
	}

	public static void main(String[] args) {
		new RediMix(); //s c r
		//10.) D
	}
}

class Concrete extends Sand {
	public Concrete() {
		System.out.print("c ");
	}

	private Concrete(String s) {
	}
}

abstract class Sand {
	Sand() {
		System.out.print("s "); 
	}
}

/*
 	11.	 Which statement(s) are true? (Choose all that apply.)
 	B.	Coupling is the OO principle most closely associated with making sure classes know about
	other classes only through their APIs.
  
*/ 
