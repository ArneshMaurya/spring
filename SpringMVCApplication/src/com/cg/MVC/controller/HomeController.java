package com.cg.MVC.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.MVC.bean.Customer;

@Controller
public class HomeController {
	
	/*
	@RequestMapping("/homePage")
	public String displayHomePage(Model model) {
		LocalDate date=LocalDate.now();
		model.addAttribute("today",date);
		return "Home";
		
	}*/
	@RequestMapping(method=RequestMethod.GET,value="/homePage")
	public ModelAndView displayHaomePage(){
		LocalDate date=LocalDate.now();
		ModelAndView mv=new ModelAndView();
		mv.addObject("today",date);
		
		//or ModelAndView mv=new ModeAndView("Home","today",date);
		mv.setViewName("Home");
		return mv;
		
	}
	@RequestMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model){
		Customer customer=new Customer();
		model.addAttribute("customer", customer);
		return "CustomerRegistration";
		
	}
	@RequestMapping("/Authenticate")
	public String authenticate(@Valid @ModelAttribute("customer")Customer customer,BindingResult result,Model model){
		
		if(result.hasErrors()) {
			return "CustomerRegistration";
		}
		model.addAttribute("customer", customer);
		
		return "Success";
	}

}
