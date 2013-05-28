package practice.exam.one;

public class Dec26 {
	
	public static void main(String[] args) {	
		short a1 = 6;
		new Dec26().go(a1);
		new Dec26().go(new Integer(7));
		
		//2.) B.) i N
		
	}

	private void go(Short x){
		System.out.println("S ");
	}
	private void go(Long x){
		System.out.println("L ");
	}
	private void go(int x){
		System.out.println("i ");
	}	
	private void go(Number n){
		System.out.println("N ");
	}

}
