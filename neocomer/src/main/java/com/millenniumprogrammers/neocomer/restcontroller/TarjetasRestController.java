package com.millenniumprogrammers.neocomer.restcontroller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.millenniumprogrammers.neocomer.model.Mediospago;
import com.millenniumprogrammers.neocomer.model.Ubicaciones;
import com.millenniumprogrammers.neocomer.service.UTarjetasService;
import com.millenniumprogrammers.neocomer.service.UUbicacionesService;

@RestController
@RequestMapping("Tarjetas")
public class TarjetasRestController {

	@Autowired
	UTarjetasService service;

	@GetMapping("/lista/{id_cliente}")
	public Map<String, Object> getTarjetas(@PathVariable("id_cliente") int id_cliente) {
		Mediospago param = new Mediospago();
		param.setId_cliente(id_cliente);
		return service.getTarjetas(param);
	}

	@PostMapping("/RegistrarTarjeta")
	public Map<String, Object> RegistrarTarjetas(@RequestBody Mediospago mediospago) {
		return service.RegistrarTarjetas(mediospago);
	}

	@PostMapping("DeleteTarjeta")
	public Map<String, Object> DeleteTarjetas(@RequestBody Mediospago mediospago) {
		return service.DeleteTarjetas(mediospago);
	}

	/*
	 * @Autowired UUbicacionesService UubicacionesService;
	 * 
	 * @GetMapping("/lista/{idcliente}") public Map<String,Object> getTarjetas(int
	 * idcliente) { Ubicaciones param = new Ubicaciones(); Map<String,Object> rpta =
	 * new HashMap<String, Object>(); rpta.put("Tarjetas",
	 * UubicacionesService.getUbicaciones(param)); return rpta; }
	 */
}
