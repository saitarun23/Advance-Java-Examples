package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String openPage(Model mm) {
		mm.addAttribute("msg", "Simplilearn");
		mm.addAttribute("id", 100);
		mm.addAttribute("name", "Sai Tarun");
		mm.addAttribute("age", 24);
		return "index";
	}

}
