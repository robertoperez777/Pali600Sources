package assesment.tests.two;

class SafeDeposit {
	private static SafeDeposit singleton;
	public static SafeDeposit getInstance(int code) {
		if(singleton == null) {
			singleton = new SafeDeposit(code);
		}
		return singleton;
	}
	private int code;
	private SafeDeposit(int c) {	
		code = c;
	}
	int getCode(){
		return code;
	}
}

public class BeSafe {

	//Insert lots of code here
	public static void main(String[] args) {

	}
	//13.) B.) Class BeSafe can create many instances of SafeDeposit.  F.9 Once class BeSafe has created an instance of SafeDeposit, it cannot change the value
	// of the instance’s "code" variable.
}