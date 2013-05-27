package assesment.tests.one;

public class Jail {
	private int x = 4;
	public static void main(String[] args) {
		protected int x = 6; //Compilation error
		new Jail().new Cell().slam();
	}
	class Cell {
		public void slam() {		
			System.out.println("throw away key " + x);
		}		
	}
	//2.) D
}
