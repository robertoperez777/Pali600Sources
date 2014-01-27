package org.koushik.javabrains.Lesson01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource(
				"src/main/resources/spring01.xml"));
		Triangle triangle = (Triangle) factory.getBean("triangle");
		triangle.draw();
	}
}
