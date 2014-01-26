package org.koushik.javabrains.Lesson16;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

public class Circle implements Shape {

	private Point center;

	@Override
	public void draw() {
		System.out.println("Draw Circle");
		System.out.println("Circle: Point is (" + center.getX() + ", "
				+ center.getY() + ") ");
	}

	public Point getCenter() {
		return center;
	}

	@Resource(name = "pointC")
	public void setCenter(Point center) {
		this.center = center;
	}

	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of circle");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy of circle");
	}

}
