package org.koushik.javabrains.Lesson19;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring19.xml");
		Shape circle = (Shape) context.getBean("circle");
		circle.draw();
	}
}
