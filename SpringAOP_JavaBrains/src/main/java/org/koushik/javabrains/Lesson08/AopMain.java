package org.koushik.javabrains.Lesson08;

import org.koushik.javabrains.Lesson08.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring08.xml");
		ShapeService shapeService = ctx.getBean("shapeService",
				ShapeService.class);
		shapeService.getCircle();
	}
}
