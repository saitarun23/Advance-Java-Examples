package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	// http://localhost:9090
		@RequestMapping(value = "",method = RequestMethod.GET)
		public String openPage() {
			System.out.println("before index page open this method called.");
			return "index";		// using view resolver it search page inside templates model.
		}
		
		// http://localhost:9090/loginPage
		@RequestMapping(value = "loginPage",method = RequestMethod.GET)
		public String loginPageOpen() {
			System.out.println("before index page open this method called.");
			return "login";		// using view resolver it search page inside templates model.
		}
}
