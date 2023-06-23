package com.sprindock.demo;

// import org.hibernate.mapping.List;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import javax.sql.DataSource;

@SpringBootApplication
@RestController
@RequestMapping("/api/v1/customers")
public class Main {

	private final CustomerRepo customerRepository;

	public Main(CustomerRepo customerRepository) {
		this.customerRepository = customerRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}


	@GetMapping
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}

	record AddCustomerRequest(
		String name,
		String email,
		Integer age
	) {
	}

	@PostMapping
	public void addCustomer(@RequestBody AddCustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);		
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id){
		customerRepository.deleteById(id);
	}

//	@Configuration
//	public static class DataSourceConfig {
//		@Bean
//		public DataSource getDataSource() {
//			return DataSourceBuilder.create()
//					.driverClassName("org.postgresql.Driver")
//					.url("jdbc:postgresql://localhost:5432/customer_test")
//					.username("avimehta")
//					.password("12345678")
//					.build();
//		}
//	}

}
