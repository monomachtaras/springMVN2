package lgs.service;

import java.util.List;

import lgs.entity.Customer;

public interface CustomerService {
	
	void addCustomer(String log, String pass, String mail);	
	void addCustomer(Customer customer);
	Customer getCustomerById(int id);
	List <Customer> getAllCustomers();
	void update(Customer customer);
	
}
