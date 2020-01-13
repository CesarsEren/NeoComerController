package com.millenniumprogrammers.neocomer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Ubicaciones;
import com.millenniumprogrammers.neocomer.repository.UbicacionesDAO;
import com.millenniumprogrammers.neocomer.repository.ZonasdisponiblesDAO;

@Service
public class ZonasDisponiblesServiceImpl implements ZonasDisponiblesService{

	@Autowired
	ZonasdisponiblesDAO zonasmapper;
	
	@Override
	public Map<String, Object> ZonasNoDisponibles(Ubicaciones ubicaciones) {
		// TODO Auto-generated method stub 
		Map<String,Object> resultado = new HashMap<>();
		resultado.put("zonas", zonasmapper.SelectNoActiveZone(ubicaciones));
		return resultado;
	}

	@Override
	public Map<String, Object> PuntosEnMapa() {
		// TODO Auto-generated method stub
		Map<String,Object> resultado = new HashMap<>();
		resultado.put("puntos", zonasmapper.SelectUbicacionesInnerJoin(null));
		return resultado;
	}

	@Override
	public Map<String, Object> PuntosEnMapaPorCategoria(String referencia) {
		// TODO Auto-generated method stub
		Map<String,Object> resultado = new HashMap<>();
		resultado.put("puntos", zonasmapper.SelectUbicacionesInnerJoinPorCategoria(referencia));
		return resultado;
	}

	@Autowired
	UbicacionesDAO ubicacionesdao;
	@Override
	public Map<String, Object> PuntosEnMapaAndUbicacion(int id_cliente, String nombreubicacion) {
		// TODO Auto-generated method stub
		Map<String,Object> resultado = new HashMap<>();
		resultado.put("puntos", zonasmapper.SelectUbicacionesInnerJoin(null));
		resultado.put("ubicacion",ubicacionesdao.SelectByIdAndNombreUbicacion(id_cliente,nombreubicacion));
		return resultado;
	}
	 
}
