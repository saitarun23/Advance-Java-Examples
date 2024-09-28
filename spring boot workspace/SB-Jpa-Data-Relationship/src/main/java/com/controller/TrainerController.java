package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Trainer;
import com.service.TrainerService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class TrainerController {
	
	@Autowired
	TrainerService trainerService;
	
/*	@RequestMapping(value = "",method = RequestMethod.GET)
	public String openPage(Model mm, Trainer tt) {
		List<Trainer> trainers = trainerService.findAllTrainer();
		mm.addAttribute("trainers", trainers);
		mm.addAttribute("trainer", tt);
		return "index";
	}
	
	
	@RequestMapping(value = "storeTrainer",method = RequestMethod.POST)
	public String storeTrainer(Model mm, Trainer tt) {
		String result = trainerService.storeTrainer(tt);
		List<Trainer> trainers = trainerService.findAllTrainer();
		tt.setTech("");
		tt.setTid(0);
		tt.setTname("");
		mm.addAttribute("trainers", trainers);
		mm.addAttribute("result", result);
		mm.addAttribute("trainer", tt);
		return "index";
	}
	
	@RequestMapping(value = "deleteTrainer",method = RequestMethod.GET)
	public String deleteTrainer(Model mm, Trainer tt, @RequestParam("tid") int tid) {
		//System.out.println("Delete method called.."+tid);
		String result = trainerService.deleteTrainerDetails(tid);
		List<Trainer> trainers = trainerService.findAllTrainer();
		tt.setTid(0);
		mm.addAttribute("result", result);
		mm.addAttribute("trainers", trainers);
		mm.addAttribute("trainer", tt);
		return "index";
	}
*/
	
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String openPage(Model mm, Trainer tt) {
		List<Trainer> trainers = trainerService.findAllTrainer();
		mm.addAttribute("trainers", trainers);
		mm.addAttribute("trainer", tt);
		mm.addAttribute("submitButton", "Store Trainer");
		return "index";
	}
	
	
	@RequestMapping(value = "storeOrUpdateTrainer",method = RequestMethod.POST)
	public String storeTrainer(Model mm, Trainer tt, HttpServletRequest req) {
		String buttonNameValue = req.getParameter("b1");
		//System.out.println(buttonNameValue);
		String result = "";
		if(buttonNameValue.equals("Store Trainer")) {
			result = trainerService.storeTrainer(tt);
		}else {
			result = trainerService.updateTrainerTechnology(tt);
		}
		List<Trainer> trainers = trainerService.findAllTrainer();
		tt.setTech("");
		tt.setTid(0);
		tt.setTname("");
		mm.addAttribute("trainers", trainers);
		mm.addAttribute("result", result);
		mm.addAttribute("trainer", tt);
		mm.addAttribute("submitButton", "Store Trainer");
		return "index";
	}
	
	@RequestMapping(value = "deleteTrainer",method = RequestMethod.GET)
	public String deleteTrainer(Model mm, Trainer tt, @RequestParam("tid") int tid) {
		//System.out.println("Delete method called.."+tid);
		String result = trainerService.deleteTrainerDetails(tid);
		List<Trainer> trainers = trainerService.findAllTrainer();
		tt.setTid(0);
		mm.addAttribute("result", result);
		mm.addAttribute("trainers", trainers);
		mm.addAttribute("trainer", tt);
		mm.addAttribute("submitButton", "Store Trainer");
		return "index";
	}
	
	
	@RequestMapping(value = "findTrainer",method = RequestMethod.GET)
	public String findTrainerById(Model mm, Trainer tt, @RequestParam("tid") int tid) {
		//System.out.println("Delete method called.."+tid);
		tt = trainerService.findTrainerById(tid);	// tt hold trainer details retrieve from db. 
		List<Trainer> trainers = trainerService.findAllTrainer();
		mm.addAttribute("trainers", trainers);
		mm.addAttribute("trainer", tt);		// tt hold trainer record retrieve from db. 
		mm.addAttribute("submitButton", "Update Trainer");
		return "index";
	}
}
