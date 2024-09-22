package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Login;

@Controller
public class LoginController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String openPage(Model mm, Login ll) {  // DI for Model API part of spring framework  as well as Login object. 
		mm.addAttribute("msg", "SAI TARUN");  // request.setAttribute("msg","Akash");
		mm.addAttribute("id", 100);
		mm.addAttribute("name", "saitarun");
		mm.addAttribute("age", 21);
		mm.addAttribute("login", ll);		// ll object store in model scope. 
		return "index";
	}

	@RequestMapping(value = "checkLogin",method = RequestMethod.POST)
	public String checkLoginDetails(Model mm, Login ll) {
		if(ll.getEmailid().equals("akash@gmail.com") && ll.getPassword().equals("123")) {
			mm.addAttribute("result", "akash@gmail.com");
			return "success";
		}else {
			return "failure";
		}
	}
}
