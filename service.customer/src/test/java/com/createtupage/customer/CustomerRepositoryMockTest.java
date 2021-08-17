package com.createtupage.customer;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.createtupage.customer.entity.Customer;
import com.createtupage.customer.entity.IdentificacionType;
import com.createtupage.customer.repository.CustomerRepository;

@DataJpaTest
public class CustomerRepositoryMockTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Test 
	public void test1() {
		
		Customer customer = new Customer();
		customer.builder()
				.id(null)
				.name("Camilo")
				.lastName("Equisdé")
				.idType(IdentificacionType.builder().id(1L).build())
				.idNumber("12345")
				.cityBirth("Copacabana")
				.creationDate(new Date(1993, 8, 06))
				.build();
		//customerRepository.save(customer);

		List<Customer> founds = customerRepository.findByIdType(customer.getIdType());
		//List<Customer> founds2 = customerRepository.findAll();
		founds.forEach(c -> System.out.println(c.getLastName()));
		//System.out.println(founds.findFirst().get().getLastName());
		//Assertions.assertThat(founds2.size()).isEqualTo(2);
	}
}
