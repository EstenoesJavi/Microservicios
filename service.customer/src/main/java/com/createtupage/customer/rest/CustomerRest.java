package com.createtupage.customer.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.createtupage.customer.entity.Customer;
import com.createtupage.customer.entity.IdentificacionType;
import com.createtupage.customer.repository.CustomerRepository;
import com.createtupage.customer.service.CustomerService;
import com.createtupage.customer.util.ErrorMessage;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customers")
public class CustomerRest {

	private final CustomerService customerService;
	private final CustomerRepository customerRepository;
	
	@GetMapping()
	public ResponseEntity<List<Customer>> listCustomer(@RequestParam(name = "idType", required = false) Long idType) {
		List<Customer> customers = new ArrayList<>();
		if(null == idType) {
			customers = customerService.listAll();
			if(customers.isEmpty()){
				return ResponseEntity.noContent().build();
			} 
		}else {
			customers = customerService.findByIdType(IdentificacionType.builder().id(idType).build());
			if(customers.isEmpty()){
				return ResponseEntity.notFound().build();
			} 
		}
		return ResponseEntity.ok(customers);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id){
		Customer customer =  customerService.getCustomer(id);
		if(null == customer) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customer);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer){
		customer.setId(id);
		Customer customerUpdated = customerService.updateCustomer(customer);
		if(customerUpdated == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customerUpdated);
	}
	
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer, BindingResult result) {
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ErrorMessage.formatMessage(result));
		}
		Customer customerCreated = customerService.createCustomer(customer);
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(customerCreated);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") Long id){
		Customer customerDeleted = customerService.deleteCustomer(id);
		if(customerDeleted == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(customerDeleted);
	}
}
