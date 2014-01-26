package org.koushik.javabrains.Lesson19;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	@Autowired
	private MessageSource messageSource;

	private ApplicationEventPublisher publisher;

	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle",
				null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point",
				new Object[] { center.getX(), center.getY() },
				"Default Point Message", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

	@Resource
	public void setCenter(Point center) {
		this.center = center;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@PostConstruct
	public void initializeCircle() {
		System.out.println("Init of circle");
	}

	@PreDestroy
	public void destroyCircle() {
		System.out.println("Destroy of circle");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

}
