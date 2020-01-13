package com.millenniumprogrammers.neocomer.service;

import java.util.Map;

import com.millenniumprogrammers.neocomer.model.Ubicaciones;

public interface ZonasDisponiblesService {
	public Map<String,Object>ZonasNoDisponibles(Ubicaciones ubicaciones);
	
	public Map<String,Object>PuntosEnMapaAndUbicacion(int id_cliente,String nombreubicacion);
	
	public Map<String,Object>PuntosEnMapa();

	public Map<String, Object> PuntosEnMapaPorCategoria(String referencia);

}
