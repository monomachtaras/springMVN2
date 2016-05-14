package lgs.service;

import java.util.List;

import lgs.entity.Customer;

public interface CustomerService {

	
	void addCustomer(String log, String pass, String mail);
	
	Customer getCustomerById(int id);
	List <Customer> getAllCustomers();
	
}
