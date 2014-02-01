package org.koushik.javabrains.Lesson09.service;

import org.koushik.javabrains.Lesson09.aspect.Loggable;
import org.koushik.javabrains.Lesson09.model.Circle;
import org.koushik.javabrains.Lesson09.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;

	@Loggable
	public Circle getCircle() {
		System.out.println("Circle getter called");
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
}
