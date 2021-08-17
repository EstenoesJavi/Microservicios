package com.createtupage.customer.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.createtupage.customer.entity.Customer;
import com.createtupage.customer.entity.IdentificacionType;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	public List<Customer> findByIdentificationType(IdentificacionType idType);
}
