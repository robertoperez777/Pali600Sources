package practice.exam.three;

import java.util.ArrayList;
import java.util.List;

class Radio {

	String getFreq() {
		return "97.3";
	}
	static String getF() {
		return "97.3";
	}
}

public class Ham extends Radio {
	
	String getFreq(){
		return "50.1";
	}
	static String getF() {
		return "50.1";
	}
	
	public static void main(String[] args) {
		List<Radio> radios = new ArrayList<Radio>();
		radios.add(new Radio());
		radios.add(new Ham());
		for (Radio r : radios) {
			System.out.println(r.getFreq() + " " + r.getF() + " ");
		}
	}
	//3.) E.	 97.3 97.3 50.1 97.3

}
