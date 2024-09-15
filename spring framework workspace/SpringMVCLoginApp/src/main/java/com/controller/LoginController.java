package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Login;
import com.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value = "checkLogin",method = RequestMethod.POST)
	public ModelAndView checkLoginDetails(HttpServletRequest req) {  // DI for HttpServletReqeust
		String emaiid = req.getParameter("emailid");
		String password = req.getParameter("password");
		ModelAndView mav = new ModelAndView();
		if(emaiid.equals("akash@gmail.com") && password.equals("123")) {
			mav.setViewName("success.jsp");
		}else {
			mav.setViewName("failure.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value = "signin",method = RequestMethod.POST)
	public ModelAndView signFromDb(HttpServletRequest req,Login login) {  // DI for HttpServletReqeust and Login class. 
		String emaiid = req.getParameter("emailid");
		String password = req.getParameter("password");
		
		login.setEmailid(emaiid);
		login.setPassword(password);
		
		String result = loginService.signIn(login);
		
		ModelAndView mav = new ModelAndView();
		if(result.equals("success")) {
			mav.setViewName("success.jsp");
		}else {
			mav.setViewName("failure.jsp");
		}
		return mav;
	}
	
	@RequestMapping(value = "signup",method = RequestMethod.POST)
	public ModelAndView signupFromDb(HttpServletRequest req,Login login) {  // DI for HttpServletReqeust and Login class. 
		String emaiid = req.getParameter("emailid");
		String password = req.getParameter("password");
		
		login.setEmailid(emaiid);
		login.setPassword(password);
		
		String result = loginService.signUp(login);
		
		ModelAndView mav = new ModelAndView();
		if(result.equals("success")) {
			mav.setViewName("signupsuccess.jsp");
		}else {
			mav.setViewName("signupfailure.jsp");
		}
		return mav;
	}
}
