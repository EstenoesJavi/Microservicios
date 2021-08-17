package com.createtupage.customer;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.createtupage.customer.repository.CustomerRepository;
import com.createtupage.customer.service.CustomerService;

@SpringBootTest
public class CustomerServiceMockTest {
	
	@Mock
	private CustomerRepository customerRepository;
	
	private CustomerService customerService;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
	}

}
