package lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lgs.entity.Customer;
import lgs.service.CityService;
import lgs.service.CustomerService;

@Controller
public class MainController {

	
	@Autowired
	private CustomerService cusS;
	
	@Autowired
	private CityService cityS;
	
	@RequestMapping("/")
	public String welcome(Model model){ 		
		//model.addAttribute("xxx", "main page");
		model.addAttribute("customers", cusS.getAllCustomers());
		model.addAttribute("cities", cityS.getAllCities());
		return "base";}
	
	@RequestMapping(value="addCustomer", method=RequestMethod.POST)
	public String add(
			@RequestParam String login, @RequestParam("eMail")String eMail, @RequestParam String password
			){
		
		
		cusS.addCustomer(login, password, eMail);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="addCity", method=RequestMethod.POST)
	public String addCity(
			@RequestParam String cityName
			){		
		cityS.addCity(cityName);
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="aaa")
	public String nextPage(){	
		return "next";
	}
	
	
	
}
