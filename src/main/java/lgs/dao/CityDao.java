package lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lgs.entity.City;

public interface CityDao extends JpaRepository<City, Integer>{
	
	
//	@Modifying
	@Query("from City c where c.cityName like :name")
	List<City> getCityByName(@Param("name") String name);
	
	@Query("from City c join fetch c.customers")
	List<City> citiesWithCustomers();
	
	

	

}
