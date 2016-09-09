package lgs.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class City {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cityName;
	
	@Lob
	private byte files[];
	
	
	@OneToMany(mappedBy="city", fetch=FetchType.EAGER)
	private List<Customer> customers;

	public City() {
		super();
	}

	
	
	
	
	public City(String cityName, byte[] files) {
		super();
		this.cityName = cityName;
		this.files = files;
	}





	public City(String cityName) {
		super();
		this.cityName = cityName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "City [cityName=" + cityName + "]";
	}
	
		
}
