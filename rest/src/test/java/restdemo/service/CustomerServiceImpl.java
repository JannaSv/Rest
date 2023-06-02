package restdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import restdemo.model.Customer;
import restdemo.repository.CustomerRepository;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer getById(Long id) {
		log.info("IN CustomerServiceImpl getById {}", id);
		return customerRepository.getReferenceById(id);
	}

	public void save(Customer customer) {
		log.info("IN CustomerServiceImpl save {}", customer);
		customerRepository.save(customer);

	}

	public void delete(Long id) {
		log.info("IN CustomerServiceImpl delete {}", id);
		customerRepository.deleteById(id);

	}

	public List<Customer> getAll() {
		log.info("IN CustomerServiceImpl getAll");
		return customerRepository.findAll();
	}

}
