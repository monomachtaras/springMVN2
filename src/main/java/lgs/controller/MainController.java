package lgs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lgs.editor.CityEditor;
import lgs.entity.City;
import lgs.entity.Customer;
import lgs.service.CityService;
import lgs.service.CustomerService;
import lgs.valid.CustomerValid;

@Controller
public class MainController {

	
	@Autowired
	private CustomerService customerService;	
	@Autowired
	private CityService cityService;
	@Autowired
	private CityEditor cityEditor;
	@Autowired
	private CustomerValid customerValid;
	
	
	
	@RequestMapping("/")
	public String welcome(Model model){ 		
		//model.addAttribute("xxx", "main page");
		model.addAttribute("customers", customerService.getAllCustomers());
		model.addAttribute("cities", cityService.getAllCities());
		model.addAttribute("emptyObj", new Customer());
		return "base";}
	
	@RequestMapping(value="addCustomer", method=RequestMethod.POST)
	public String add(
			@RequestParam String login, @RequestParam("eMail")String eMail, @RequestParam String password
			){		
		customerService.addCustomer(login, password, eMail);		
		return "redirect:/";
	}
	
	@RequestMapping(value="addCity", method=RequestMethod.POST)
	public String addCity(
			@RequestParam String cityName
			){		
		cityService.addCity(cityName);		
		return "redirect:/";
	}
	
	
	
	@RequestMapping(value="connect", method=RequestMethod.POST)
	public String connect(
			@RequestParam String bindCustomer,  @RequestParam String bindCity
			){	
		City city = cityService.getCityById(Integer.valueOf(bindCity));
		Customer customer = customerService.getCustomerById(Integer.valueOf(bindCustomer));
		customer.setCity(city);
		customerService.update(customer);
		return "redirect:/";
	}
	
	@RequestMapping(value="sf" , method=RequestMethod.POST)
	public String sf(Model model,
			@ModelAttribute("emptyObj") @Valid Customer customer, BindingResult bindingResult
			){
		if(bindingResult.hasErrors()){
		model.addAttribute("customers", customerService.getAllCustomers());
		model.addAttribute("cities", cityService.getAllCities());
		return "base";
		}
		customerService.addCustomer(customer);
		return "redirect:/";
	}
	
	@InitBinder
	public void binder(WebDataBinder dataBinder){		
		dataBinder.registerCustomEditor(City.class, cityEditor);
		dataBinder.addValidators(customerValid);
	}
	
	
	
	@RequestMapping("/all")
	public String showAll(Model model){
		model.addAttribute("allCustomersWithAllCities", cityService.allCitiesWithCustomers());
		return "all-anything";
	}
	
	@RequestMapping("/toLoginPage")
	public String loging(){
			return "loginMe";
	}
	
	
	
	
	
	
	
	
	
	
	
}
