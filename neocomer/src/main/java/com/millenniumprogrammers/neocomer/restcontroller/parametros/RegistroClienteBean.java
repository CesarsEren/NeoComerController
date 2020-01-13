package com.millenniumprogrammers.neocomer.restcontroller.parametros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroClienteBean {

	//Persona
	String Nombres;
	String Apellidos; 
	String Documento;
	String FechaNacimiento;
	//Cliente
	String Correo;
	String Password;
	//Direccion
	String Apodo;
	double longitud;
	double latitud;
	String direccion;
	
	//data
	int id_cliente;//funciona como id_vendeor e id_cliente
	int id_persona;
	//para cliente y vendedor
	String foto;
}
