package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Login;
import com.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "checkLoginDetails",method = RequestMethod.POST)
	public String checkLoginInformation(HttpServletRequest req) {			// DI for HttpServletRequest 
		String emailid = req.getParameter("email");
		String password = req.getParameter("password");
		if(emailid.equals("akash@gmail.com") && password.equals("123")) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	@RequestMapping(value = "signInFromDb",method = RequestMethod.POST)
	public String signIn(HttpServletRequest req,Login ll) {	// DI for HttpServletRequest and Login ll
		String emailid = req.getParameter("email");			// taking the value through form 
		String password = req.getParameter("password");		// taking the value through forms. 
		
		ll.setEmailid(emailid);
		ll.setPassword(password);
		
		String result = loginService.signIn(ll);
		System.out.println(result);
		if(result.equals("success")) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	@RequestMapping(value = "signUpFromDb",method = RequestMethod.POST)
	public String signUp(HttpServletRequest req,Login ll) {	// DI for HttpServletRequest and Login ll
	
		String emailid = req.getParameter("email");			// taking the value through form 
		String password = req.getParameter("password");		// taking the value through forms. 
		
		ll.setEmailid(emailid);
		ll.setPassword(password);
		
		String result = loginService.signUp(ll);
		System.out.println(result);
		return "signup";
	}
}
