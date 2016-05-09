package lgs.dao.imp;

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

}
