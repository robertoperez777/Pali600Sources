package practice.exam.one;

public class Volume {
	Volume v;
	int size;
	public static void main(String[] args) {
		Volume myV = new Volume();
		final Volume v2;
		v2 = myV.doStuff(myV);
		v2.v.size = 7;
		System.out.println(v2.size);
		// 4.) A.	 5
	}
	
	private Volume doStuff(Volume v3) {	
		v3.size = 5;
		v3.v = new Volume();
		return v3;
	}

}
