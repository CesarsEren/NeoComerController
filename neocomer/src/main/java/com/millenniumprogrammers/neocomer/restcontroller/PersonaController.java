package com.millenniumprogrammers.neocomer.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.millenniumprogrammers.neocomer.model.Persona;
import com.millenniumprogrammers.neocomer.service.PersonaNEO;

//@CrossOrigin
@RestController
@RequestMapping("/personas")
public class PersonaController {
 
	@Autowired
	PersonaNEO neo;

	@GetMapping()
	public List<Persona> index() {
		return neo.findAll();
	}
	
	@GetMapping("/page/{page}")
	public Page<Persona> index(@PathVariable Integer page) {
		Pageable pageable = PageRequest.of(page, 10);
		return neo.findAll(pageable);
	}

}
