package lgs.valid;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lgs.entity.Customer;
@Component
public class CustomerValid implements Validator {

	public boolean supports(Class<?> clazz) {		
		return Customer.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Customer customer = (Customer) target;
		if(customer.getLogin().isEmpty()) {
			errors.rejectValue("login", "bylba", "login is empty");
		}
		
	}

}
