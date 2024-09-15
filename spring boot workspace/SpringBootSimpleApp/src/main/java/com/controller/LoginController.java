package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@RequestMapping(value = "checkLoginDetails",method = RequestMethod.POST)
	public String checkLoginInformation(HttpServletRequest req) {
		String emailid = req.getParameter("email");
		String password = req.getParameter("password");
		if(emailid.equals("akash@gmail.com") && password.equals("123")) {
			return "success";
		}else {
			return "failure";
		}
	}
}
