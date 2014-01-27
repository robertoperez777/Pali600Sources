package org.koushik.javabrains.Lesson03;

public class Triangle {

	private final String type;
	private int height;

	public Triangle(String type) {
		super();
		this.type = type;
	}

	public Triangle(String type, int height) {
		super();
		this.type = type;
		this.height = height;
	}

	public String getType() {
		return type;
	}

	public int getHeight() {
		return height;
	}

	public void draw() {
		System.out.println(getType() + " Triangle drawn");
	}
}
