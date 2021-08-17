package com.createtupage.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createtupage.customer.entity.Customer;
import com.createtupage.customer.entity.IdentificacionType;
import com.createtupage.customer.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

	private final CustomerRepository customerRepository;
	
	@Override
	public List<Customer> listAll() {
		return customerRepository.findAll();
	}
	
	@Override
	public Customer getCustomer(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if(customer.isEmpty()) {
			return null;
		}
		return customer.get();
	}
	
	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		
		Customer customerForId = getCustomer(customer.getId());
		if(customerForId == null) {
			return null;
		}
		customerForId.setName(customer.getName());
		customerForId.setLastName(customer.getLastName());
		customerForId.setIdentificationType(customer.getIdentificationType());
		customerForId.setIdNumber(customer.getIdNumber());
		customerForId.setCityBirth(customer.getCityBirth());
		return customerRepository.save(customer);
	}

	@Override
	public Customer deleteCustomer(Long idCustomer) {
		
		Customer customerForId = getCustomer(idCustomer);
		if(customerForId == null) {
			return null;
		}
		customerRepository.deleteById(idCustomer);
		return customerForId;
	}

	@Override
	public List<Customer> findByIdType(IdentificacionType idType) {
		return customerRepository.findByIdentificationType(idType);
	}

}
