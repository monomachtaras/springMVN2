package lgs.dao.imp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lgs.dao.CustomerDao;
import lgs.entity.Customer;


@Repository
public class CustomerDaoImp implements CustomerDao {

	@PersistenceContext
	EntityManager manager;
	
	
	public void addCustomer(Customer customer) {
		manager.persist(customer);
		
	}


	public Customer getCustomerById(int id) {
		
		return manager.find(Customer.class, id);
	}


	public List<Customer> getAllCustomers() {
		
		return manager.createQuery("from Customer", Customer.class).getResultList();
	}

}
