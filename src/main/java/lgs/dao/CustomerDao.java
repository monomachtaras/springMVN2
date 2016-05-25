package lgs.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import lgs.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	
}
