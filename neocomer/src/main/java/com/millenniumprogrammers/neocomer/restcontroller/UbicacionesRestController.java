package com.millenniumprogrammers.neocomer.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.millenniumprogrammers.neocomer.model.Ubicaciones;
import com.millenniumprogrammers.neocomer.service.UUbicacionesService;

@RestController
@RequestMapping("Ubicaciones")
public class UbicacionesRestController {
	
	@Autowired
	UUbicacionesService ubicacionesservice;
	
	@GetMapping("/lista/{id_cliente}")
	public Map<String,Object>getUbicacionesPorCliente(@PathVariable("id_cliente")int id_cliente)
	{
		Ubicaciones  ubicaciones= new Ubicaciones();
		ubicaciones.setId_cliente(id_cliente);
		return ubicacionesservice.getUbicaciones(ubicaciones);
	}

	@PostMapping("/RegistrarUbicacion")
	public Map<String,Object>RegistrarUbicacion(@RequestBody Ubicaciones ubicaciones){
		return ubicacionesservice.RegistrarUbicacion(ubicaciones);		
	}
}
