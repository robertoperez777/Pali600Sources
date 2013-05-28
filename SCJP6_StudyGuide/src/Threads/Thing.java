package Threads;

public class Thing {
	private static int staticField;
	private int nonstaticField;

	public static synchronized int getStaticField() {
		return staticField;
	}

	public static synchronized void setStaticField(int staticField) {
		Thing.staticField = staticField;
	}

	public synchronized int getNonStaticField() {
		return nonstaticField;
	}

	public synchronized void setNonStaticField(int nonStaticField) {
		this.nonstaticField = nonStaticField;
	}
}
