package com.cg.MVC.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.MVC.bean.Customer;
import com.cg.MVC.db.LoginDetails;
import com.cg.MVC.service.ICustomerService;

@Controller
public class HomeController {
	@Autowired
	ICustomerService service;
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
	public String authenticate(@Valid @ModelAttribute("customer")Customer customer,
			BindingResult result,Model model){
		
		if(result.hasErrors()) {
			return "CustomerRegistration";
		}
		customer=service.addCustomer(customer);
		model.addAttribute("customer", customer);
		/*LoginDetails details=new LoginDetails();
		
		details.addDetails(customer.getMobno(), customer.getPassword());*/
		
		return "Success";
	}
	@RequestMapping("/update")
	public String update() {
		return "Find";
		
	}
	@RequestMapping("/check")
	public Customer check(@RequestParam("Id")int id,Model model) {
		
		return service.update(id);
		
	}
	@RequestMapping("/customerList")
	public String show() {
		
	}
	/*@RequestMapping("/login")
	public String login() {
		
		return "Login";
	}*/
	/*@RequestMapping("/validate")
	public String validate(@RequestParam("mobno")String mobno,@RequestParam("password")String password,Model model) {
		LoginDetails details=new LoginDetails();
		
		HashMap<String, String> map1=details.getDetails();
		System.out.println(details.getDetails());
		for(String key:map1.keySet()) {
			if(key==mobno) {
				if(map1.get(key)==password) {
					return "Page1";
				}
				else
					return "Login";
			}
			
			else
				return "Login";
		}
		
		return "Login";
		
		
		
	}*/
}
