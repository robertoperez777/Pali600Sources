package practice.exam.three;
enum MyEnum {HI, ALOHA, HOWDY}

public class PassEnum {

	public static void main(String[] args) {
		PassEnum p = new PassEnum();
		MyEnum[] v = MyEnum.values();
		v = MyEnum.getValues(); //Comp fail
		for (MyEnum me: MyEnum.values()) {
			p.getEnum(me);
		}
		for (int x = 0; x < MyEnum.values().length; x++) {
			p.getEnum(v[x]);
		}
		for (int x = 0; x < MyEnum.length; x++) {
			p.getEnum(v[x]);
		}
		for (MyEnum me : v) {
			p.getEnum(me);
		}
	}
	public void getEnum(MyEnum e) {
		System.out.println(e + " ");
	}

	/* 7.)
		C.	 line 6
		F.	line 9
	 */
}
