package com.millenniumprogrammers.neocomer.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RestController;

import com.millenniumprogrammers.neocomer.model.Ubicaciones;


public interface UUbicacionesService {
	
	public Map<String,Object> getUbicaciones(Ubicaciones ubicaciones);  
	
	public Map<String,Object> RegistrarUbicacion(Ubicaciones ubicaciones);
	
	
	

}
