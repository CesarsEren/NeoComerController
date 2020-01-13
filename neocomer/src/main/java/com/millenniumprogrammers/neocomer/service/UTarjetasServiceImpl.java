package com.millenniumprogrammers.neocomer.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Mediospago;
import com.millenniumprogrammers.neocomer.repository.MediospagoDAO;

@Service
public class UTarjetasServiceImpl implements UTarjetasService {

	@Autowired
	MediospagoDAO pagomapper;

	@Override
	public Map<String, Object> getTarjetas(Mediospago mediospago) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<String, Object>();
		List<Mediospago>lista=pagomapper.SelectById(mediospago);
		for(Mediospago item: lista)
		{
			item.setNroTarjeta(item.getNroTarjeta().substring(0, 15)+"XXXX");
		}
		rpta.put("Tarjetas", lista);
		return rpta;
	}

	@Override
	public Map<String, Object> RegistrarTarjetas(Mediospago mediospago) {
		// TODO Auto-generated method stub
		pagomapper.Register(mediospago);
		Map<String, Object> rpta = new HashMap<String, Object>();
		rpta.put("msgserver", "aceptado");
		// rpta.put("Tarjetas", pagomapper.SelectById(mediospago));
		return rpta;
	}

	@Override
	public Map<String, Object> DeleteTarjetas(Mediospago mediospago) {
		// TODO Auto-generated method stub
		  pagomapper.Delete(mediospago);
		Map<String, Object> rpta = new HashMap<String, Object>();
		rpta.put("msgserver", "Aceptado");
		/*if (i != 0) {
			rpta.put("msgserver", "aceptado");
		} else { 
			rpta.put("msgserver", "Error");
		}*/
		return rpta;
	}

}
