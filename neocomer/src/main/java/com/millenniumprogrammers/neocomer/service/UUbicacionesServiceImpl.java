package com.millenniumprogrammers.neocomer.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Ubicaciones;
import com.millenniumprogrammers.neocomer.repository.UbicacionesDAO;

@Service
public class UUbicacionesServiceImpl implements UUbicacionesService{

	@Autowired
	UbicacionesDAO ubimapper;
	
	@Override
	public Map<String,Object>  getUbicaciones(Ubicaciones ubicaciones) {
		// TODO Auto-generated method stub
		Map<String,Object>  rpta = new HashMap<>();
		rpta.put("ubicaciones", ubimapper.SelectById(ubicaciones));
		return rpta;
	}

	@Override
	public Map<String,Object>  RegistrarUbicacion(Ubicaciones ubicaciones) {
		// TODO Auto-generated method stub 
		ubimapper.Register(ubicaciones); 
		Map<String,Object>  rpta = new HashMap<>();
		rpta.put("msgserver", "aceptado");
		rpta.put("ubicaciones", ubimapper.SelectById(ubicaciones));  
		return rpta;
	}

}
