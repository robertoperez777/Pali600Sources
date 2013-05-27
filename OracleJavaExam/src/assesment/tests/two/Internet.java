package assesment.tests.two;

import java.awt.peer.TextComponentPeer;

public class Internet {
	private int y = 8;
	public static void main(String[] args) {
		new Internet().go();
		// 9.) D.)
	}
	
	void go() {
		int x = 7;
		TCPIP ip = new TCPIP(); //Compilation fails
		class TCPIP {
			void doIt() {
				System.out.println(y+x);
			}
		}
		ip.doit();
	}
}
