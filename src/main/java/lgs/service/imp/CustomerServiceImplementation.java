package lgs.service.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lgs.dao.CustomerDao;
import lgs.entity.Customer;
import lgs.service.CustomerService;


@Service
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerDao cusD;
	
	
	@Transactional
	public void addCustomer(String log, String pass, String mail) {
		cusD.addCustomer(new Customer(log, pass, mail));
		
	}


	public Customer getCustomerById(int id) {
		return cusD.getCustomerById(id);		 
	}


	public List<Customer> getAllCustomers() {		
		return cusD.getAllCustomers();
	}

    @Transactional
	public void update(Customer customer) {
		cusD.update(customer);		
	}

    @Transactional
	public void addCustomer(Customer customer) {
		cusD.addCustomer(customer);		
	}

}
