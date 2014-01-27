package org.koushik.javabrains.Lesson05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring05.xml");
		Triangle triangle = (Triangle) context.getBean("triangle-alias");
		triangle.draw();
	}
}
