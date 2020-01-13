package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personas{
    
	 private int id_persona;
	 private String DNI;
	 private String Nombres;
	 private String Apellidos;
	 private String FechaNacimiento;
	 private String FechaIngreso;
	 private boolean Estado;
	 private String Direccion;

	 //para vista de CLIENTES
	 private int id_cliente;
 }
