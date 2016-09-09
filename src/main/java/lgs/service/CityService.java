package lgs.service;

import java.util.List;

import lgs.dto.CityDTO;
import lgs.entity.City;

public interface CityService {
	void addCity(String cityName);
	void addCity(String cityName, byte []mas);
	City getCityById(int id);
	List<City> getAllCities();
	List<City> getCitiesByName(String cityName);
	List<CityDTO> allCitiesWithCustomers();
	
	

}
