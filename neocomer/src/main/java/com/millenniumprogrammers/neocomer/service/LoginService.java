package com.millenniumprogrammers.neocomer.service;

import java.util.Map;

import org.springframework.stereotype.Service;


public interface LoginService {

	
	//Cliente|Vendedor
	public Map<String,Object> IngresarAgachadito(String correo,String password);
	
	//Trabajadores **|Empadronador|**Seguridad|**Salubridad
	public Map<String,Object> IngresarNeocomer(String correo,String password);
}
