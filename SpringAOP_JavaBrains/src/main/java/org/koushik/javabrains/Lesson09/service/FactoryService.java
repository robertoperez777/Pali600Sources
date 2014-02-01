package org.koushik.javabrains.Lesson09.service;

import org.koushik.javabrains.Lesson09.model.Circle;
import org.koushik.javabrains.Lesson09.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType) {
		if (beanType.equals("shapeService")) {
			return new ShapeServiceProxy();
		}
		if (beanType.equals("circle")) {
			return new Circle();
		}
		if (beanType.equals("triangle")) {
			return new Triangle();
		}
		return null;
	}
}
