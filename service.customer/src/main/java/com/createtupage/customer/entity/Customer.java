package com.createtupage.customer.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
public class Customer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "El nombre no debe ser vacío.")
	private String name;
	
	@Column(name = "last_name")
	@NotEmpty(message = "El apellido no debe ser vacío.")
	private String lastName;

	@NotNull(message = "El tipo de identificación no debe ser vacío.")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "identificaction_type_id")
	private IdentificacionType identificationType;
	
	@Column(name = "id_number")
	@NotEmpty(message = "El número de identificación no debe ser vacío.")
	private String idNumber;
	
	@Column(name = "city_birth")
	@NotEmpty(message = "La ciudad de nacimiento no debe ser vacía.")
	private String cityBirth;

	@Column(name = "creation_date")
	@Temporal(TemporalType.DATE)
	private Date creationDate;
}
