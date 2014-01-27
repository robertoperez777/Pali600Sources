package org.koushik.javabrains.Lesson18;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring18.xml");
		context.registerShutdownHook();
		Shape circle = (Shape) context.getBean("circle");
		circle.draw();
		// System.out.println(context.getMessage("greeting", null,
		// "Default Greeting", null));
	}
}
