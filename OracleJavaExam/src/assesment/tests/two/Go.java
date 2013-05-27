package assesment.tests.two;

class Game {

	static String s = "-";
	String s2 = "s2";
	
	public Game(String arg) {
		s += arg;
	}
	
}

public class Go extends Game {
	
	public Go() {
		super(s2); //Compilation failes
		//The s2 variable is an instance variable that can’t be used in the call to super
		//because the instance hasn’t been created yet.
	}
	
	{
		s += "i ";
	}

	public static void main(String[] args) {
		new Go();
		System.out.println(s);
		
		//7.) E.)
	}
	
	static {
		s += "sb ";
	}
}
