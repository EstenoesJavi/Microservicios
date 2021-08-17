package com.createtupage.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.createtupage.customer.entity.IdentificacionType;

@Repository
public interface IdTypeRepository extends JpaRepository<IdentificacionType, Long>{

}
