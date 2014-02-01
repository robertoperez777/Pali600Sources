package org.koushik.javabrains.Lesson02;

import org.koushik.javabrains.Lesson02.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring02.xml");
		ShapeService shapeService = ctx.getBean("shapeService",
				ShapeService.class);
		System.out.println(shapeService.getTriangle().getName());
	}
}
