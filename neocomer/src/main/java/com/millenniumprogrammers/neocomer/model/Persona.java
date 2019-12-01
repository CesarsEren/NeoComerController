package com.millenniumprogrammers.neocomer.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblPersona")
public class Persona {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idpersona;
	 
	@Column(name = "nombre", length = 50)
	String nombre;
	 
	@Column(name = "apellido", length = 50)
	String apellido;
	

}
