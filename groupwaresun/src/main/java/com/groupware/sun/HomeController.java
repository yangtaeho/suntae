package com.groupware.sun;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupware.sun.common.util.SideMenu;
import com.groupware.sun.test.TestService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private TestService testService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "/index";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		List<SideMenu> sideMenu = testService.getSideMenuList();
		List<SideMenu> sideMenu1 = sideMenu;
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("sideMenu1", sideMenu1);
		System.out.println(sideMenu);
		return "index";
	}

}
