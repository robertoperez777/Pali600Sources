package org.koushik.javabrains.Lesson07;

import org.koushik.javabrains.Lesson07.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring07.xml");
		ShapeService shapeService = ctx.getBean("shapeService",
				ShapeService.class);
		shapeService.getCircle();
	}
}
