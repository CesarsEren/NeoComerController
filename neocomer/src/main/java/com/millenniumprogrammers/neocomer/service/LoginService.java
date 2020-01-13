package com.millenniumprogrammers.neocomer.service;

import java.util.Map;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Vendedores;
import com.millenniumprogrammers.neocomer.restcontroller.parametros.RegistroClienteBean;


public interface LoginService {

	
	//Cliente|Vendedor
	public ResponseEntity<Map<String,Object>> IngresarAgachadito(String correo,String password);
	
	//Trabajadores **|Empadronador|**Seguridad|**Salubridad
	public Map<String,Object> IngresarNeocomer(String correo,String password);
	
	public ResponseEntity<Map<String,Object>> RegistrarCliente(RegistroClienteBean bean);

	public ResponseEntity<Map<String, Object>> ActualizarCliente(RegistroClienteBean bean);
	public Vendedores IngresarAgachaditoUserDetails(String username);
}
