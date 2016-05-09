package lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lgs.entity.Customer;
import lgs.service.CustomerService;

@Controller
public class MainController {

	
	@Autowired
	private CustomerService cusS;
	
	@RequestMapping("/")
	public String welcome(Model model){ 
		
		model.addAttribute("xxx", "some case");
		return "welcome";}
	
	@RequestMapping(value="add", method=RequestMethod.POST)
	public String add(
			@RequestParam String login, @RequestParam("mail")String email, @RequestParam String password
			){
		
		
		cusS.addCustomer(login, password, email);
		
		return "redirect:/";
	}
	
	
	
}
