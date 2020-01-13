package com.millenniumprogrammers.neocomer.service;

import java.util.Map;

import com.millenniumprogrammers.neocomer.model.Mediospago;

public interface UTarjetasService {
	
	public Map<String,Object>getTarjetas(Mediospago mediospago);
	
	public Map<String,Object>RegistrarTarjetas(Mediospago mediospago);
	
	public Map<String,Object>DeleteTarjetas(Mediospago mediospago);

}
