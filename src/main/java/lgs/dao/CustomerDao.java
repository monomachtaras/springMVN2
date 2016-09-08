package lgs.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lgs.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
	@Query("from Customer c where c.login like:login")
	Customer findByLogin(@Param("login") String login);

	
}
