package practice.exam.one;

import java.io.IOException;

interface Risky {
	String doStuff() throws Exception;

	Risky doCrazy();

	void doInsane();
}

public class Bungee implements Risky {

	@Override
	public String doStuff() throws IOException {
		throw new IOException();
	}

	@Override
	public Bungee doCrazy() {
		return new Bungee();
	}

	@Override
	public void doInsane() throws NullPointerException {
		throw new NullPointerException();
	}

}

// 36.) A. Compilation succeeds.
