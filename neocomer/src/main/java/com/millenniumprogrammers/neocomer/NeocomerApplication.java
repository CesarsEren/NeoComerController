package com.millenniumprogrammers.neocomer;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.millenniumprogrammers.neocomer.model.Asociaciones;
import com.millenniumprogrammers.neocomer.model.Atributos;
import com.millenniumprogrammers.neocomer.model.Clientes;
import com.millenniumprogrammers.neocomer.model.Fotospuesto;
import com.millenniumprogrammers.neocomer.model.Permisos;
import com.millenniumprogrammers.neocomer.model.Personas;
import com.millenniumprogrammers.neocomer.model.Puestos;
import com.millenniumprogrammers.neocomer.model.Roles; 
import com.millenniumprogrammers.neocomer.model.Trabajadores;
import com.millenniumprogrammers.neocomer.model.Vendedores;
import com.millenniumprogrammers.neocomer.model.Zonasdisponibles;
import com.millenniumprogrammers.neocomer.repository.AsociacionesDAO;
import com.millenniumprogrammers.neocomer.repository.AtributosDAO;
import com.millenniumprogrammers.neocomer.repository.ClientesDAO;
import com.millenniumprogrammers.neocomer.repository.PermisosDAO;
import com.millenniumprogrammers.neocomer.repository.PersonasDAO;
import com.millenniumprogrammers.neocomer.repository.PuestosDAO;
import com.millenniumprogrammers.neocomer.repository.RolesDAO;
import com.millenniumprogrammers.neocomer.repository.TrabajadoresDAO;
import com.millenniumprogrammers.neocomer.repository.VendedoresDAO;
import com.millenniumprogrammers.neocomer.repository.ZonasdisponiblesDAO;

@SpringBootApplication
public class NeocomerApplication{// implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NeocomerApplication.class, args);
	}
/*
	@Autowired
	PersonasDAO perdao;
	
	@Autowired
	RolesDAO roldao;
	
	@Autowired
	ClientesDAO clidao;
	
	@Autowired
	TrabajadoresDAO tradao;
	
	@Autowired
	AsociacionesDAO asodao;
	
	@Autowired
	VendedoresDAO vendao;
 
	@Autowired
	PermisosDAO permiDAO;
	
	@Autowired
	PuestosDAO puestosDAO;
	@Autowired
	ZonasdisponiblesDAO zonasdisponiblesDAO; 
	 
	@Override
	public void run(String... args) throws Exception {
		
		Roles rol = new Roles();
		rol.setDetalle("Empadronador");
		roldao.Register(rol);
		
		Roles rol2 = new Roles();
		rol2.setDetalle("Fiscalizador Seguridad");
		roldao.Register(rol2);
		
		Roles rol3 = new Roles();
		rol3.setDetalle("Fiscalizador Salubridad");
		roldao.Register(rol3);
//------------------------------------------------
		// TODO Auto-generated method stub
		Personas per = new Personas(); //Cliente
		per.setNombres("Cesars");
		per.setApellidos("Pinedo Olivera");
		per.setDireccion("Av horacio Urteaga");
		per.setDNI("71807093");
		per.setFechaIngreso("2019-12-10");
		per.setFechaNacimiento("1996-11-11");
		per.setEstado(true);
		perdao.Register(per);
		
			Clientes cli= new Clientes();
			cli.setId_persona(per.getId_persona());
			cli.setCorreo("cpinedo428@gmail.com");
			cli.setPassword("admin");
			clidao.Register(cli);
//------------------------------------------------
		
		Personas per2 = new Personas(); //Trabajador
		per2.setNombres("Marco");
		per2.setApellidos("Alvarado Cifuentes");
		per2.setDireccion("Av horacio Urteaga");
		per2.setDNI("71807093");
		per2.setFechaIngreso("2019-10-12");
		per2.setFechaNacimiento("1996-11-11");
		per2.setEstado(true);
		perdao.Register(per2); 

			Trabajadores trab= new Trabajadores();
			trab.setCorreo("alvarado@gmail.com");
			trab.setId_persona(per2.getId_persona());
			trab.setEstado(true);
			trab.setId_rol(rol.getId_rol());//ROL EMPADRONADOR
			trab.setPassword("alvarado");
			tradao.Register(trab);
//------------------------------------------------
		
		Personas per3 = new Personas(); //Trabajador
		per3.setNombres("Marco");
		per3.setApellidos("Alvarado Cifuentes");
		per3.setDireccion("Av horacio Urteaga");
		per3.setDNI("71807093");
		per3.setFechaIngreso("2019-10-12");
		per3.setFechaNacimiento("1996-11-11");
		per3.setEstado(true);
		perdao.Register(per3); 

			Trabajadores trab2= new Trabajadores();
			trab2.setCorreo("alvarado@gmail.com");
			trab2.setId_persona(per3.getId_persona());
			trab2.setEstado(true);
			trab2.setId_rol(rol2.getId_rol());//ROL EMPADRONADOR
			trab2.setPassword("alvarado");
			tradao.Register(trab2);
//------------------------------------------------
		
		Personas per4 = new Personas(); //Trabajador
		per4.setNombres("Marco");
		per4.setApellidos("Alvarado Cifuentes");
		per4.setDireccion("Av horacio Urteaga");
		per4.setDNI("71807093");
		per4.setFechaIngreso("2019-10-12");
		per4.setFechaNacimiento("1996-11-11");
		per4.setEstado(true);
		perdao.Register(per4); 
	
			Trabajadores trab3= new Trabajadores();
			trab3.setCorreo("alvarado@gmail.com");
			trab3.setId_persona(per4.getId_persona());
			trab3.setEstado(true);
			trab3.setId_rol(rol3.getId_rol());//ROL EMPADRONADOR
			trab3.setPassword("alvarado");
			tradao.Register(trab3);
//------------------------------------------------
		

//------------------------------------------------		
		Personas per5 = new Personas(); //Vendedor
		per5.setNombres("Alberto");
		per5.setApellidos("Gutierrez Camacho");
		per5.setDireccion("Av 15 de Agosto");
		per5.setDNI("42152658");
		per5.setFechaIngreso("2019-12-10");
		per5.setFechaNacimiento("1988-5-3");
		per5.setEstado(true);
		perdao.Register(per5);
			
			Asociaciones aso = new Asociaciones();
			aso.setFechaRegistro("2019-12-10");
			aso.setRUC("20600629353");
			aso.setRazon("ASOCIACION PERUANA DE FOOD TRUCK -APEFOODT");
			aso.setDireccion("Resid. Lucyana de Carabay (Alt. del Termino de la Av. Trapiche)"); 
			aso.setEstado(true);
			asodao.Register(aso);
			
				Zonasdisponibles zona1 = new Zonasdisponibles();
				zona1.setApodo("Esquina Jr Huiracocha 1300");
				zona1.setEstado(true);
				zona1.setLongitud(-12.075089);
				zona1.setLatitud(-77.047700);
				zonasdisponiblesDAO.Register(zona1);
				
				Zonasdisponibles zona2 = new Zonasdisponibles();
				zona2.setApodo("Frente al Tio Lazaña");
				zona2.setEstado(true);
				zona2.setLongitud(-12.072967);
				zona2.setLatitud(-77.050257);
				zonasdisponiblesDAO.Register(zona2);
				
				Zonasdisponibles zona3 = new Zonasdisponibles();
				zona3.setApodo("Frente a chicharroneria al Paso");
				zona3.setEstado(true);
				zona3.setLongitud(-12.073024);
				zona3.setLatitud(-77.050308);
				zonasdisponiblesDAO.Register(zona3);
				
				Permisos permiso = new Permisos();
				permiso.setEstado(true);//ESTADO ACTIVO SI ES ACEPTADO
				permiso.setFechaRegistro("2019-12-10");
				permiso.setFechaFin("2019-12-14");
				permiso.setId_asociacion(aso.getId_asociacion());
				permiso.setId_trabajador(trab.getId_trabajador());
				permiso.setId_zona(zona3.getId_zona());
				permiDAO.Register(permiso);
				
				Puestos puestos = new Puestos();
				puestos.setColor("#F34235");
				puestos.setDetalle("FoodTruck");
				puestos.setEstado(true);
				puestos.setReferencia("Por ahí");
				puestosDAO.Register(puestos);
				
				Fotospuesto fotospuesto = new Fotospuesto();
				fotospuesto.setEstado(true);
				fotospuesto.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/emoliente2.png");
				fotospuesto.setId_puesto(puestos.getId_puesto());
				
					Vendedores ven = new Vendedores();
					ven.setCorreo("vendedor1@milleniumprogramers.com");
					ven.setPassword("vendedor1");
					ven.setEstado(permiso.isEstado());//SOLO SI TIENE PERMISO TIENE ESTADO ACTIVO
					ven.setId_persona(per5.getId_persona()); 
					ven.setId_asociacion(aso.getId_asociacion());
					ven.setId_permiso(permiso.getId_permiso());
					ven.setId_puesto(puestos.getId_puesto());
					vendao.Register(ven);
				 
	}*/
}
