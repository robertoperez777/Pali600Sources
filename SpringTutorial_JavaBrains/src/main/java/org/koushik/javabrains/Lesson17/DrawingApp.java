package org.koushik.javabrains.Lesson17;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring17.xml");
		context.registerShutdownHook();
		Shape circle = (Shape) context.getBean("circle");
		circle.draw();
	}
}
