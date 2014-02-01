package org.koushik.javabrains.Lesson02.service;

import org.koushik.javabrains.Lesson02.model.Circle;
import org.koushik.javabrains.Lesson02.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;

	public Circle getCircle() {
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
