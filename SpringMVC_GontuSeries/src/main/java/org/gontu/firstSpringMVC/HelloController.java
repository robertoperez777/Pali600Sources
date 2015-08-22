package org.gontu.firstSpringMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ModelAndView modelView = new ModelAndView("HelloPage");
		modelView.addObject("welcomeMessage","Hi user, welcome to the first Spring MVC Application");

		return modelView;
	}

}
