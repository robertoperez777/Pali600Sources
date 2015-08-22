package org.gontu.firstSpringMVC;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/greet")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public ModelAndView hiWorld(Locale locale, Model model) {
		
		ModelAndView modelView = new ModelAndView("HelloPage");
		modelView.addObject("welcomeMessage","Hi user");

		return modelView;
	}
	
	@RequestMapping(value = "/welcome/{userName}", method = RequestMethod.GET)
	public ModelAndView hiWithUserName(@PathVariable("userName") String name) {
		
		ModelAndView modelView = new ModelAndView("HelloPage");
		modelView.addObject("welcomeMessage", name);

		return modelView;
	}

	@RequestMapping(value = "/welcome/{countryName}/{userName}", method = RequestMethod.GET)
	public ModelAndView hiWithUserNameAndCountry(@PathVariable Map<String, String> pathVars) {
		
		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		
		ModelAndView modelView = new ModelAndView("HelloPage");
		modelView.addObject("welcomeMessage", "Hello " + name + " . You are from " + country);

		return modelView;
	}
	
}
