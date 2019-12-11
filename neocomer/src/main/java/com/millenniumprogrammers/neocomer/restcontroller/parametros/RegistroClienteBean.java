package com.millenniumprogrammers.neocomer.restcontroller.parametros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroClienteBean {

	String Nombres;
	String Apellidos;
	String Documento;
	String FechaNacimiento;
	String Password; 
}
