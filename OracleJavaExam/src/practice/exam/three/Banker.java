package practice.exam.three;

class Account {
	Long acctNum, password;
}

public class Banker {
	public static void main(String[] args) {
		new Banker().go();
		//do more stuff
	}

	private void go() {
		Account a1 = new Account();
		a1.acctNum = new Long("1024");
		Account a2 = a1;
		Account a3 = a2;
		a3.password = a1.acctNum.longValue();
		a2.password = 4455L;
	}
}

/*
 	B.	 a1.password == a2.password
 	D.	 Four objects are eligible for garbage collection.
 	
*/