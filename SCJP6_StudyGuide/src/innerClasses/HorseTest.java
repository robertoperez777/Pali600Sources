package innerClasses;

public class HorseTest {

	public static void main(String[] args) {
		class Horse {
			public String name;

			public Horse(String s) {
				this.name = s;
			}
		}
		Object obj = new Horse("Zippo");
		//System.out.println(obj.name);
	}

}
