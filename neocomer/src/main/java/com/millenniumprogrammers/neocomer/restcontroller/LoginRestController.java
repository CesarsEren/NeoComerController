package com.millenniumprogrammers.neocomer.restcontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.millenniumprogrammers.neocomer.model.Clientes;
import com.millenniumprogrammers.neocomer.service.LoginService;

@RestController
@RequestMapping("Rest")
public class LoginRestController {


	/*
	 * private int id_cliente; private int id_persona; private String correo;
	 * private String password;
	 */
	
	/*
	@GetMapping("loginApp/{username}/{password}")
	public Map<String,Object> getUser(@PathVariable("username")String  username, @PathVariable("password")String password) {
		List<Clientes> cli = new ArrayList<>();
		cli.add(new Clientes(1, 1, "Cesara@gmail.com", "123"));
		cli.add(new Clientes(2, 2, "Cesars@gmail.com", "124"));

		Map<String,Object> rpta = new HashMap<>();
		rpta.put("lista", cli);

		return rpta;
	}*/

	
	@Autowired
	LoginService loginservice;
	
	@GetMapping("loginApp/{correo}/{password}")
	public Map<String,Object> LoginAgachadito(@PathVariable("correo")String correo,@PathVariable("password")String password){
		return loginservice.IngresarAgachadito(correo, password); 
	}
	
	@GetMapping("loginWeb/{correo}/{password}")
	public Map<String,Object> LoginNeocomer(@PathVariable("correo")String correo,@PathVariable("password")String password){
		return loginservice.IngresarNeocomer(correo, password); 
	}
}
