package com.millenniumprogrammers.neocomer.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.millenniumprogrammers.neocomer.service.ZonasDisponiblesService;

@RestController
@RequestMapping("Zonas")
public class ZonasDisponiblesRestController {

	@Autowired
	ZonasDisponiblesService zonassevice;

	@GetMapping("/lista")
	public Map<String, Object> GetZonasNoActivas() {
		// return zonassevice.ZonasNoDisponibles(null);
		return zonassevice.PuntosEnMapa();
	}
	
	@GetMapping("/lista/{id_cliente}/{apodoubicacion}")
	public Map<String, Object> GetZonasNoActivasAndUbicacion(@PathVariable("id_cliente")int id_cliente , @PathVariable("apodoubicacion")String apodoubicacion) {
		// return zonassevice.ZonasNoDisponibles(null);
		return zonassevice.PuntosEnMapaAndUbicacion(id_cliente,apodoubicacion);
	}
	
	@GetMapping("/lista/{referencia}")
	public Map<String, Object> GetZonasNoActivasXCategorias(@PathVariable("referencia") String referencia) {//Puestos
		// return zonassevice.ZonasNoDisponibles(null);
		return zonassevice.PuntosEnMapaPorCategoria(referencia);
	}
}
