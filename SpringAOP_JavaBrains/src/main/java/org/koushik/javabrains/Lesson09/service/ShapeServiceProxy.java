package org.koushik.javabrains.Lesson09.service;

import org.koushik.javabrains.Lesson09.aspect.LoggingAspect;
import org.koushik.javabrains.Lesson09.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}
}
