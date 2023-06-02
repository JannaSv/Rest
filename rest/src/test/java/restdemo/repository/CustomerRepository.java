package restdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import restdemo.model.Customer;

public interface CustomerRepository extends JpaRepository <Customer, Long>{

}
