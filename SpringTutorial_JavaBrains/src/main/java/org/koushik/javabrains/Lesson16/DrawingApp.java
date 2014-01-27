package org.koushik.javabrains.Lesson16;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring16.xml");
		context.registerShutdownHook();
		Shape triangle = (Shape) context.getBean("triangle");
		Shape circle = (Shape) context.getBean("circle");
		triangle.draw();
		circle.draw();
	}
}
