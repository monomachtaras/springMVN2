package lgs.service.imp;

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

}
