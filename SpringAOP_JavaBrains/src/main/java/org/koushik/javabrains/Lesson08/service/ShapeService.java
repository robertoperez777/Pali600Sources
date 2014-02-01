package org.koushik.javabrains.Lesson08.service;

import org.koushik.javabrains.Lesson08.aspect.Loggable;
import org.koushik.javabrains.Lesson08.model.Circle;
import org.koushik.javabrains.Lesson08.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;

	@Loggable
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
