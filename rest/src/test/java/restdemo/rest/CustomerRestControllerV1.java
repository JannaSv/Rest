package restdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import restdemo.model.Customer;
import restdemo.service.CustomerService;


@RestController
@RequestMapping("/api/v1/customers/")
public class CustomerRestControllerV1 {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long customerId) {
		
		if(customerId==null) return new ResponseEntity<Customer> (HttpStatus.BAD_REQUEST);
		
		Customer customer = this.customerService.getById(customerId);
		
		if(customer==null) return new ResponseEntity<Customer> (HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.OK); 
		
		
		
	}
	
	@PostMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
		
		if(customer==null) return new ResponseEntity<Customer> (HttpStatus.BAD_REQUEST);
		
		this.customerService.save(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
		
		
	}
	
	@PutMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, UriComponentsBuilder builder) {
		
		if(customer==null) return new ResponseEntity<Customer> (HttpStatus.BAD_REQUEST);
		
		this.customerService.save(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
		
	}
	
	@DeleteMapping(value="{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id) {
		
		if(id==null) return new ResponseEntity<Customer> (HttpStatus.BAD_REQUEST);
		
		Customer customer = this.customerService.getById(id);
		if(customer==null) return new ResponseEntity<Customer> (HttpStatus.NOT_FOUND);
		
		this.customerService.delete(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.NO_CONTENT);
		
		
	}
	
	@GetMapping(value="", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomer() {
		
		List<Customer> customers = this.customerService.getAll();
		
		if(customers.isEmpty()) return new ResponseEntity<List<Customer>> (HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK); 
		
		
		
	}
}
