package org.koushik.javabrains.Lesson04;

import org.koushik.javabrains.Lesson04.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring04.xml");
		ShapeService shapeService = ctx.getBean("shapeService",
				ShapeService.class);
		shapeService.getCircle().setName("Dummy name");
		// System.out.println(shapeService.getCircle().getName());
	}
}
