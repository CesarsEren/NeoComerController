package com.millenniumprogrammers.neocomer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import com.millenniumprogrammers.neocomer.model.Persona;

public interface PersonaNEO {

	public List<Persona> findAll();

	public Page<Persona> findAll(Pageable pageable);

	public Persona findById(Integer id);

	public Persona save(Persona persona);

	public void delete(Integer id);

}
