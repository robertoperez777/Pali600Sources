package practice.exam.one;

public interface Syrupable {
	void getSugary();
}

abstract class Pancake implements Syrupable {
	
}

class BlueBerryPancake implements Pancake {
	public void getSugary() {
		
	}
}

class SourdoughBluberryPancake extends BluberryPancake {
	void getSugary(int s){
		;
	}
}
