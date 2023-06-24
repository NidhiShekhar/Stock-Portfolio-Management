package com.sprindock.demo;

import java.util.List;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

	record CustomerRequest(
		String name,
		String email,
		Integer age
	){
	}

	@GetMapping
	public List<Customer> getCustomers(){
		return customerRepository.findAll();
	}

	@PostMapping
	public void addCustomer(@RequestBody CustomerRequest request) {
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

	@PutMapping("customerId}")
	public ResponseEntity<Customer> updateEmployee(@PathVariable("customerId") Integer id, @RequestBody CustomerRequest request) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer does not exist with id: " + id));
		customer.setName(request.name());
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
		return ResponseEntity.ok(customer);
	}

}
