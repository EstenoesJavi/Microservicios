package com.createtupage.customer.service;

import java.util.List;

import com.createtupage.customer.entity.Customer;
import com.createtupage.customer.entity.IdentificacionType;

public interface CustomerService {
	
	public List<Customer> listAll();
	public Customer getCustomer(Long id);
	public Customer createCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer deleteCustomer(Long idCustomer);
	public List<Customer> findByIdType(IdentificacionType idType);
}
