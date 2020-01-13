package com.millenniumprogrammers.neocomer.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Asociaciones;
import com.millenniumprogrammers.neocomer.model.Clientes;
import com.millenniumprogrammers.neocomer.model.Personas;
import com.millenniumprogrammers.neocomer.model.Roles;
import com.millenniumprogrammers.neocomer.model.Trabajadores;
import com.millenniumprogrammers.neocomer.model.Ubicaciones;
import com.millenniumprogrammers.neocomer.model.Usuario;
import com.millenniumprogrammers.neocomer.model.Vendedores;
import com.millenniumprogrammers.neocomer.repository.ClientesDAO;
import com.millenniumprogrammers.neocomer.repository.PersonasDAO;
import com.millenniumprogrammers.neocomer.repository.RolesDAO;
import com.millenniumprogrammers.neocomer.repository.TrabajadoresDAO;
import com.millenniumprogrammers.neocomer.repository.UbicacionesDAO;
import com.millenniumprogrammers.neocomer.repository.VendedoresDAO;
import com.millenniumprogrammers.neocomer.repository.ZonasdisponiblesDAO;
import com.millenniumprogrammers.neocomer.restcontroller.LoginRestController;
import com.millenniumprogrammers.neocomer.restcontroller.parametros.RegistroClienteBean;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	PersonasDAO permapper;

	@Autowired
	UbicacionesDAO ubimapper;

	@Autowired
	VendedoresDAO venmapper;

	@Autowired
	ClientesDAO climapper;

	@Autowired
	TrabajadoresDAO tramapper;

	@Autowired
	RolesDAO rolesmapper;
	@Autowired
	ZonasdisponiblesDAO zonasmapper;

	@Override
	public ResponseEntity<Map<String, Object>> IngresarAgachadito(String correo, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();

		Personas param = new Personas();
		Personas rptapersonas = new Personas();

		Clientes clientes = null;
		clientes = climapper.SelectByCorreoAndPassword(correo, password);
		if (clientes != null) {
			param.setId_persona(clientes.getId_persona());
			rptapersonas = permapper.SelectById(param);
			rptapersonas.setId_cliente(clientes.getId_cliente());
			rpta.put("msgserver", "Bienvenido " + rptapersonas.getNombres());
			rpta.put("Persona", rptapersonas);
			rpta.put("foto", clientes.getFoto());
			rpta.put("Rol", "Cliente");
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.OK);
		} else {
			Vendedores vendedores = null;
			vendedores = venmapper.SelectByCorreoAndPassword(correo, password);
			if (vendedores != null) {
				param.setId_persona(vendedores.getId_persona());
				rptapersonas = permapper.SelectById(param);
				rptapersonas = permapper.SelectById(param);
				rptapersonas.setId_cliente(vendedores.getId_vendedor());
				rpta.put("msgserver", "Bienvenido " + rptapersonas.getNombres());
				rpta.put("Persona", rptapersonas);
				rpta.put("Puesto", zonasmapper.SelectUbicacionesInnerJoinPorIdVendedor(rptapersonas.getId_cliente()));
				rpta.put("Rol", "Vendedor");
				return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.OK);
			} else {
				rpta.put("msgserver", "Datos no Encontrados");
				return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.NOT_FOUND);
			}
		}
	}

	@Override
	public Map<String, Object> IngresarNeocomer(String correo, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();
		Personas param = new Personas();
		Personas rptapersonas = new Personas();
		Roles rolparam = new Roles();
		Trabajadores trabajadores = null;
		trabajadores = tramapper.SelectByCorreoAndPassword(correo, password);
		if (trabajadores != null) {
			param.setId_persona(trabajadores.getId_persona());
			rptapersonas = permapper.SelectById(param);
			rolparam.setId_rol(trabajadores.getId_rol());
			rolparam = rolesmapper.SelectById(rolparam);
			rpta.put("msgserver", "Welcome " + rptapersonas.getNombres() + " es UD. " + rolparam.getDetalle());
			rpta.put("Persona", rptapersonas);
		} else {
			rpta.put("msgserver", "Datos no Encontrados");
		}
		return rpta;
	}

	@Override
	public ResponseEntity<Map<String, Object>> RegistrarCliente(RegistroClienteBean bean) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();

		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Fecha: " + dateFormat.format(date));
		if (bean.getCorreo().contains("@") && !bean.getApellidos().isEmpty() && !bean.getApodo().isEmpty()
				&& !bean.getCorreo().isEmpty() && !bean.getDocumento().isEmpty() && !bean.getPassword().isEmpty()) {
			Personas personas = new Personas();
			personas.setDNI(bean.getDocumento());
			personas.setNombres(bean.getNombres());
			personas.setApellidos(bean.getApellidos());
			personas.setEstado(true);
			personas.setDireccion(bean.getDireccion());
			personas.setFechaIngreso(dateFormat.format(date));
			personas.setFechaNacimiento(bean.getFechaNacimiento());
			permapper.Register(personas);

			Clientes clientes = new Clientes();
			clientes.setCorreo(bean.getCorreo());
			clientes.setId_persona(personas.getId_persona());
			clientes.setPassword(bean.getPassword());
			// ***
			climapper.Register(clientes);

			Ubicaciones ubicaciones = new Ubicaciones();
			ubicaciones.setId_cliente(clientes.getId_cliente());
			ubicaciones.setApodo(bean.getApodo());
			ubicaciones.setDireccion(bean.getDireccion());
			ubicaciones.setLatitud(bean.getLatitud());
			ubicaciones.setLongitud(bean.getLongitud());
			// ***
			ubimapper.Register(ubicaciones);

			personas.setId_cliente(clientes.getId_cliente());

			rpta.put("Persona", personas);
			rpta.put("msgserver", "Aceptado");
			rpta.put("foto", clientes.getFoto());
			rpta.put("Rol", "Cliente");
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.OK);
		} else {
			rpta.put("msgserver", "datos incorrectos");
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.BAD_GATEWAY);
		}

	}

	@Override
	public ResponseEntity<Map<String, Object>> ActualizarCliente(RegistroClienteBean bean) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();
		Personas personas = new Personas();
		personas.setApellidos(bean.getApellidos());
		personas.setNombres(bean.getNombres());
		personas.setFechaNacimiento(bean.getFechaNacimiento());
		personas.setId_persona(bean.getId_persona());
		permapper.Update(personas);
		personas = permapper.SelectById(personas);
		Clientes cli = new Clientes();

		cli.setFoto(bean.getFoto());
		cli.setId_cliente(bean.getId_cliente());
		climapper.UpdateFoto(cli);
		rpta.put("msgserver", "SUCCESS");
		rpta.put("foto", cli.getFoto());
		rpta.put("Persona", personas);
		if (bean.getNombres().isEmpty()) { 
			rpta.put("msgserver", "Nombre Vacio");
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.BAD_GATEWAY);
		} else if (bean.getApellidos().isEmpty()) {
			rpta.put("msgserver", "Apellido Vacio");
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.BAD_GATEWAY);
		} else if (bean.getDocumento().isEmpty()) {
			rpta.put("msgserver", "Documento Vacio");
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.BAD_GATEWAY);
		}else {
			return new ResponseEntity<Map<String, Object>>(rpta, HttpStatus.ACCEPTED);	
		}
		
	}

	@Override
	public Vendedores IngresarAgachaditoUserDetails(String username) {
		// TODO Auto-generated method stub
		return new Vendedores(1, 2, 1, 1, "vendedor1@yopmail.com", "vendedor1", true, 1);
	}

}
