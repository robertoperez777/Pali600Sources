package org.koushik.javabrains.Lesson02;

public class Triangle {

	private String type;

	public void draw() {
		System.out.println(getType() + " Triangle drawn");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
