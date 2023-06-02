package restdemo.service;

import java.util.List;

import restdemo.model.Customer;

public interface CustomerService {

	Customer getById(Long id);
	
	void save(Customer customer);
	
	void delete(Long id);
	
	List<Customer> getAll();
}
