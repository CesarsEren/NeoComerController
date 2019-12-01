package com.millenniumprogrammers.neocomer.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.millenniumprogrammers.neocomer.model.Persona;
import com.millenniumprogrammers.neocomer.repository.PersonaDAO;

@Service
public class PersonaNEOImpl implements PersonaNEO{

	@Autowired
	private PersonaDAO personaDAO;
 
	@Override
	@Transactional(readOnly = true) 
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return (List<Persona>) personaDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true) 
	public Page<Persona> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return  personaDAO.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findById(Integer id) {
		// TODO Auto-generated method stub
		return personaDAO.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona save(Persona persona) {
		// TODO Auto-generated method stub
		return personaDAO.save(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		personaDAO.deleteById(id);
	} 
}
