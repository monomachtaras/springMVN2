package lgs.dao;

import java.util.List;

import lgs.entity.Customer;

public interface CustomerDao {

	void addCustomer(Customer customer);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomers();
	
	
	
}
