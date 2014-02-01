package org.koushik.javabrains.Lesson09;

import org.koushik.javabrains.Lesson09.service.FactoryService;
import org.koushik.javabrains.Lesson09.service.ShapeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring09.xml");
		// ShapeService shapeService = ctx.getBean("shapeService",
		// ShapeService.class);
		FactoryService factoryService = new FactoryService();
		ShapeService shapeService = (ShapeService) factoryService
				.getBean("shapeService");
		shapeService.getCircle();
	}
}
