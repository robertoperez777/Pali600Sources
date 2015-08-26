package object.exercise11;

public class Exercise11 {
	public static void main(String[] args) {
		AllTheColorsOfTheRainbow allTheColorsOfTheRainbow = new AllTheColorsOfTheRainbow();
		allTheColorsOfTheRainbow.chageTheHueOfTheColor(11);
	}
}

class AllTheColorsOfTheRainbow {
	int anIntegerRepresentingColors;
	void chageTheHueOfTheColor(int newHue) {
		anIntegerRepresentingColors = newHue;
	}
}