package com.millenniumprogrammers.neocomer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Asociaciones;
import com.millenniumprogrammers.neocomer.model.Clientes;
import com.millenniumprogrammers.neocomer.model.Personas;
import com.millenniumprogrammers.neocomer.model.Roles;
import com.millenniumprogrammers.neocomer.model.Personas.PersonasBuilder;
import com.millenniumprogrammers.neocomer.model.Trabajadores;
import com.millenniumprogrammers.neocomer.model.Vendedores;
import com.millenniumprogrammers.neocomer.repository.ClientesDAO;
import com.millenniumprogrammers.neocomer.repository.PersonasDAO;
import com.millenniumprogrammers.neocomer.repository.RolesDAO;
import com.millenniumprogrammers.neocomer.repository.TrabajadoresDAO;
import com.millenniumprogrammers.neocomer.repository.VendedoresDAO;
import com.millenniumprogrammers.neocomer.restcontroller.LoginRestController;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	PersonasDAO permapper;

	@Autowired
	VendedoresDAO venmapper;

	@Autowired
	ClientesDAO climapper;

	@Autowired
	TrabajadoresDAO tramapper;

	@Autowired
	RolesDAO rolesmapper;

	@Override
	public Map<String, Object> IngresarAgachadito(String correo, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();

		Personas param = new Personas();
		Personas rptapersonas = new Personas();

		Clientes clientes = null;
		clientes = climapper.SelectByCorreoAndPassword(correo, password);
		if (clientes != null) {
			param.setId_persona(clientes.getId_persona());
			rptapersonas = permapper.SelectById(param);
			rpta.put("msgserver", "Bienvenido " + rptapersonas.getNombres());
			rpta.put("Persona", rptapersonas);
			rpta.put("Rol", "Cliente");
		} else {
			Vendedores vendedores = null;
			vendedores = venmapper.SelectByCorreoAndPassword(correo, password);
			if (vendedores != null) {
				param.setId_persona(vendedores.getId_persona());
				rptapersonas = permapper.SelectById(param);
				rpta.put("msgserver", "Bienvenido " + rptapersonas.getNombres());
				rpta.put("Persona", rptapersonas);
				rpta.put("Rol", "Vendedor");
			} else {
				rpta.put("msgserver", "Datos no Encontrados");
			}
		}

		return rpta;
	}

	@Override
	public Map<String, Object> IngresarNeocomer(String correo, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();
		
		Personas param = new Personas();
		Personas rptapersonas = new Personas();
		Roles rolparam =new Roles();
		Trabajadores trabajadores =null;
		trabajadores = tramapper.SelectByCorreoAndPassword(correo, password);
		if(trabajadores!=null)
		{
			param.setId_persona(trabajadores.getId_persona());
			rptapersonas = permapper.SelectById(param);
			rolparam.setId_rol(trabajadores.getId_rol());
			rolparam = rolesmapper.SelectById(rolparam);
			rpta.put("msgserver", "Bienvenido "+rptapersonas.getNombres()+" es UD. "+rolparam.getDetalle());
			rpta.put("Persona",rptapersonas); 
		}
		else
		{
			rpta.put("msgserver", "Datos no Encontrados");
		}
		
		return rpta;
	}

}
