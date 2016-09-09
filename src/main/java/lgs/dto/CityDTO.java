package lgs.dto;

import java.util.List;

public class CityDTO {
	
	private String name;
	private List<String> customers;
	public CityDTO(String name, List<String> customers) {
		super();
		this.name = name;
		this.customers = customers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getCustomers() {
		return customers;
	}
	public void setCustomers(List<String> customers) {
		this.customers = customers;
	}
	
	

}
