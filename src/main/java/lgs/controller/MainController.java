package lgs.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import lgs.editor.CityEditor;
import lgs.entity.City;
import lgs.entity.Customer;
import lgs.service.CityService;
import lgs.service.CoordinatesService;
import lgs.service.CustomerService;
import lgs.valid.CustomerValid;

@Controller
public class MainController {
	
	@Autowired
	private CoordinatesService coordinatesService;	
	@Autowired
	private CustomerService customerService;	
	@Autowired
	private CityService cityService;
	@Autowired
	private CityEditor cityEditor;
	@Autowired
	private CustomerValid customerValid;
	
	@RequestMapping(value="/jsonservlet", method=RequestMethod.POST)
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if (request == null) {
			System.out.println("request is null");
		} else {
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

			String json = "";
			if (br != null) {
				String red = br.readLine();
				if (red != null) {
					json = red;
					ArrayList<String> list = new ArrayList<String>();
					StringTokenizer tokenizer = new StringTokenizer(json, " ");
					while (tokenizer.hasMoreTokens()) {
						String a = tokenizer.nextToken();
						list.add(a);
					}
					coordinatesService.addCoordinates(list.get(0)+" "+list.get(1), list.get(2), list.get(3));
				}
			}
			response.setContentType("application/json");

		}	
	}
	
	@RequestMapping("/allCoordinates")
	public String showAllCoordinates(Model model){
		model.addAttribute("allCoordinates", coordinatesService.getAllCoordinates());		
		return "showallcoordinates";
	}
	

	@RequestMapping("/")
	public String welcome(Model model) 	{ 		
		
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
	
	
	
	
	@ModelAttribute("emptyObj")
	public Customer asd(){
		return new Customer();
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
	
	
	
	@RequestMapping("all")
	public String showAll(Model model){
		model.addAttribute("allCustomersWithAllCities", cityService.allCitiesWithCustomers());
		System.out.println("in aaaaaaaaaaaaal");
		return "all-anything";
	}
	
	@RequestMapping("/toLoginPage")
	public String loging(){
			return "loginMe";
	}
	
	
	@RequestMapping(value="addCity2", method=RequestMethod.POST)
	public String add2(
			@RequestParam String cityName, @RequestParam("file") MultipartFile file
			) throws IOException{	
			cityService.addCity(cityName, file.getBytes()); ;	
		return "redirect:/";
	}
	
	
}
