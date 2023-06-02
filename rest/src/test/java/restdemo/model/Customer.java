package restdemo.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customers")
public class Customer extends BaseEntity {
	
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="budget")
	private BigDecimal budget;
	

}
