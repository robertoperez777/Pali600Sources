package org.koushik.javabrains.Lesson09.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {

	// @Around("allGetters()")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("Before advice");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("After Returning");
		} catch (Throwable e) {
			System.out.println("After throwing");
		}
		System.out.println("After finally");
		return returnValue;
	}

	public void loggingAdvice() {
		System.out.println("Logging from the advice");
	}
}
