package lgs.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lgs.dao.CityDao;
import lgs.dto.CityDTO;
import lgs.entity.City;
import lgs.entity.Customer;
import lgs.service.CityService;

@Service
public class CityServiceImp implements CityService {

	@Autowired
	private CityDao cityDao;

	@Transactional
	public void addCity(String cityName) {
		cityDao.save(new City(cityName));
	}

	@Transactional
	public void addCity(String cityName, byte[] mas) {
		cityDao.save(new City(cityName, mas));
	}

	public City getCityById(int id) {
		return cityDao.findOne(id);
	}

	public List<City> getAllCities() {
		return cityDao.findAll();
	}

	public List<City> getCitiesByName(String cityName) {
		return cityDao.getCityByName(cityName);
	}

	public List<City> citiesWithCustomers() {
		return cityDao.citiesWithCustomers();
	}

	public List<CityDTO> allCitiesWithCustomers() {
		List<CityDTO> dtos = new ArrayList<CityDTO>();		
		List<City> cities = citiesWithCustomers();
		
		for (City city : cities) {
			List<String> strings = new ArrayList<String>();
			List<Customer> customers = city.getCustomers();
			
			for (Customer customer : customers) {
				strings.add(customer.getLogin().toString() + " " + customer.geteMail().toString());
			}

			dtos.add(new CityDTO(city.getCityName(), strings));
		}
		
		return dtos;
	}

}
