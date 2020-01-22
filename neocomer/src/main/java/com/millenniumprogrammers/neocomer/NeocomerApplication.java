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
import com.millenniumprogrammers.neocomer.model.Mediospago;
import com.millenniumprogrammers.neocomer.model.Permisos;
import com.millenniumprogrammers.neocomer.model.Personas;
import com.millenniumprogrammers.neocomer.model.Productos;
import com.millenniumprogrammers.neocomer.model.Puestos;
import com.millenniumprogrammers.neocomer.model.Roles; 
import com.millenniumprogrammers.neocomer.model.Trabajadores;
import com.millenniumprogrammers.neocomer.model.Ubicaciones;
import com.millenniumprogrammers.neocomer.model.Vendedores;
import com.millenniumprogrammers.neocomer.model.Zonasdisponibles;
import com.millenniumprogrammers.neocomer.repository.AsociacionesDAO;
import com.millenniumprogrammers.neocomer.repository.AtributosDAO;
import com.millenniumprogrammers.neocomer.repository.ClientesDAO;
import com.millenniumprogrammers.neocomer.repository.FotospuestoDAO;
import com.millenniumprogrammers.neocomer.repository.MediospagoDAO;
import com.millenniumprogrammers.neocomer.repository.PermisosDAO;
import com.millenniumprogrammers.neocomer.repository.PersonasDAO;
import com.millenniumprogrammers.neocomer.repository.ProductosDAO;
import com.millenniumprogrammers.neocomer.repository.PuestosDAO;
import com.millenniumprogrammers.neocomer.repository.RolesDAO;
import com.millenniumprogrammers.neocomer.repository.TrabajadoresDAO;
import com.millenniumprogrammers.neocomer.repository.UbicacionesDAO;
import com.millenniumprogrammers.neocomer.repository.VendedoresDAO;
import com.millenniumprogrammers.neocomer.repository.ZonasdisponiblesDAO;

@SpringBootApplication
public class NeocomerApplication {//implements CommandLineRunner{

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
	
	@Autowired
	UbicacionesDAO ubicacionesDAO; 
	  
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
			//cli.setCorreo("cpinedo428@gmail.com");
			cli.setCorreo("admin");
			cli.setPassword("admin");
			clidao.Register(cli);
			//Metodo de Pago de Cliente
			Mediospago m = new Mediospago();
			m.setId_cliente(cli.getId_cliente());
			m.setCCV("556");
			m.setApellido("BBB");
			m.setNombre("AAA");
			m.setFechaVenc("12/21");
			m.setNroTarjeta("1523658748958624");
			pagomapper.Register(m);
			
				Ubicaciones u  = new Ubicaciones();
				u.setId_cliente(cli.getId_cliente());
				u.setDireccion("Av horacio Urteaga");
				u.setApodo("Parque");
				u.setLongitud(-77.048648);
				u.setLatitud(-12.074270);
				ubicacionesDAO.Register(u);
				
				Ubicaciones u2  = new Ubicaciones();
				u2.setId_cliente(cli.getId_cliente());
				u2.setDireccion("Av horacio Urteaga");
				u2.setApodo("Mi Casa"); 
				u2.setLongitud(-77.046568);
				u2.setLatitud(-12.071774);
				ubicacionesDAO.Register(u2);
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
		per3.setNombres("Alicia");
		per3.setApellidos("Cerna Pajuelo");
		per3.setDireccion("Av horacio Urteaga");
		per3.setDNI("70485962");
		per3.setFechaIngreso("2019-10-12");
		per3.setFechaNacimiento("1996-11-11");
		per3.setEstado(true);
		perdao.Register(per3); 

			Trabajadores trab2= new Trabajadores();
			trab2.setCorreo("alicia@gmail.com");
			trab2.setId_persona(per3.getId_persona());
			trab2.setEstado(true);
			trab2.setId_rol(rol2.getId_rol());//ROL EMPADRONADOR
			trab2.setPassword("alicia");
			tradao.Register(trab2);
//------------------------------------------------
		
		Personas per4 = new Personas(); //Trabajador
		per4.setNombres("Antonio");
		per4.setApellidos("Seguil Tamayo");
		per4.setDireccion("Av horacio Urteaga");
		per4.setDNI("5486592");
		per4.setFechaIngreso("2019-10-12");
		per4.setFechaNacimiento("1996-11-11");
		per4.setEstado(true);
		perdao.Register(per4); 
	
			Trabajadores trab3= new Trabajadores();
			trab3.setCorreo("seguil@gmail.com");
			trab3.setId_persona(per4.getId_persona());
			trab3.setEstado(true);
			trab3.setId_rol(rol3.getId_rol());//ROL EMPADRONADOR
			trab3.setPassword("seguil");
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
		
//----------------------------------------------
		
		Personas per6 = new Personas(); //Vendedor
		per6.setNombres("Victor Hugo ");
		per6.setApellidos("Chavez Martinez");
		per6.setDireccion("Av 15 de Agosto");
		per6.setDNI("45263215");
		per6.setFechaIngreso("2019-12-31");
		per6.setFechaNacimiento("1978-01-05");
		per6.setEstado(true);
		perdao.Register(per6);
		
//----------------------------------------------
		Personas per7 = new Personas(); //Vendedor
		per7.setNombres("Giancarlo");
		per7.setApellidos("Puelles Peña");
		per7.setDireccion("Av los Castaños");
		per7.setDNI("09565645");
		per7.setFechaIngreso("2020-01-04");
		per7.setFechaNacimiento("1995-11-05");
		per7.setEstado(true);
		perdao.Register(per7);
			
			Asociaciones aso = new Asociaciones();
			aso.setFechaRegistro("2019-12-10");
			aso.setRUC("20600629353");
			aso.setRazon("ASOCIACION PERUANA DE FOOD TRUCK -APEFOODT");
			aso.setDireccion("Resid. Lucyana de Carabay (Alt. del Termino de la Av. Trapiche)"); 
			aso.setEstado(true);
			asodao.Register(aso);
			
			Asociaciones aso2 = new Asociaciones();
			aso2.setFechaRegistro("2019-12-31");
			aso2.setRUC("20604226296");
			aso2.setRazon("ASOCIACION DE EMOLIENTEROS Y BEBIDAS DEL PERU");
			aso2.setDireccion("JR. SAN ESTEFANO MZA. A LOTE. 01 COO. LOS JAZMINES DE SAN ROQUE LIMA - LIMA - SANTIAGO DE SURCO"); 
			aso2.setEstado(true);
			asodao.Register(aso2);
			
			
				Zonasdisponibles zona1 = new Zonasdisponibles();
				zona1.setApodo("Esquina Jr Huiracocha 1300");
				zona1.setEstado(false);
				zona1.setLongitud(-77.047700);
				zona1.setLatitud(-12.075089);
				zonasdisponiblesDAO.Register(zona1);
				
				Zonasdisponibles zona2 = new Zonasdisponibles();
				zona2.setApodo("Frente al Tio Lazaña");
				zona2.setEstado(false);
				zona2.setLongitud(-77.050257);
				zona2.setLatitud(-12.072967);
				zonasdisponiblesDAO.Register(zona2);
				
				Zonasdisponibles zona3 = new Zonasdisponibles();
				zona3.setApodo("Frente a chicharroneria al Paso");
				zona3.setEstado(false);
				zona3.setLongitud(-77.050308);
				zona3.setLatitud(-12.073024);
				zonasdisponiblesDAO.Register(zona3);
				
				Permisos permiso = new Permisos();
				permiso.setEstado(true);//ESTADO ACTIVO SI ES ACEPTADO
				permiso.setFechaRegistro("2019-12-10");
				permiso.setFechaFin("2019-12-14");
				permiso.setId_asociacion(aso.getId_asociacion());
				permiso.setId_trabajador(trab.getId_trabajador());
				permiso.setId_zona(zona3.getId_zona());
				permiDAO.Register(permiso);
				
				Permisos permiso2 = new Permisos();
				permiso2.setEstado(true);//ESTADO ACTIVO SI ES ACEPTADO
				permiso2.setFechaRegistro("2019-12-10");
				permiso2.setFechaFin("2019-12-14");
				permiso2.setId_asociacion(aso2.getId_asociacion());
				permiso2.setId_trabajador(trab2.getId_trabajador());
				permiso2.setId_zona(zona2.getId_zona());
				permiDAO.Register(permiso2);
				
				Permisos permiso3 = new Permisos();
				permiso3.setEstado(true);//ESTADO ACTIVO SI ES ACEPTADO
				permiso3.setFechaRegistro("2019-12-10");
				permiso3.setFechaFin("2019-12-14");
				permiso3.setId_asociacion(aso2.getId_asociacion());
				permiso3.setId_trabajador(trab2.getId_trabajador());
				permiso3.setId_zona(zona1.getId_zona());
				permiDAO.Register(permiso3); 
				
				Puestos puestos = new Puestos();
				puestos.setColor("#F34235");
				puestos.setDetalle("Jalapeños FoodTruck");
				puestos.setEstado(true);
				puestos.setReferencia("Hamburguesas");
				puestosDAO.Register(puestos);
			 
				Puestos puestos2 = new Puestos();
				puestos2.setColor("#F34235");
				puestos2.setDetalle("Emolientes la China");
				puestos2.setEstado(true);
				puestos2.setReferencia("Emolientes");
				puestosDAO.Register(puestos2);
				
				Puestos puestos3 = new Puestos();
				puestos3.setColor("#F34235");
				puestos3.setDetalle("Emolientes Don Carlos");
				puestos3.setEstado(true);
				puestos3.setReferencia("Emolientes");
				puestosDAO.Register(puestos3);
				
				//-12.076341, -77.048067
				Fotospuesto fotospuesto = new Fotospuesto();
				fotospuesto.setEstado(true);
				fotospuesto.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/jalape%C3%B1os.PNG");
				fotospuesto.setId_puesto(puestos.getId_puesto());
				fotosPuestodao.Register(fotospuesto);
				
				Fotospuesto fotospuesto2 = new Fotospuesto();
				fotospuesto2.setEstado(true);
				fotospuesto2.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/emoliente2.png");
				fotospuesto2.setId_puesto(puestos2.getId_puesto());
				fotosPuestodao.Register(fotospuesto2);
				
				Fotospuesto fotospuesto3 = new Fotospuesto();
				fotospuesto3.setEstado(true);
				fotospuesto3.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/jalape%C3%B1os.PNG");
				fotospuesto3.setId_puesto(puestos3.getId_puesto());
				fotosPuestodao.Register(fotospuesto3);
				
					Vendedores ven = new Vendedores();
					ven.setCorreo("vendedor1@yopmail.com");
					ven.setPassword("vendedor1");
					ven.setEstado(permiso.isEstado());//SOLO SI TIENE PERMISO TIENE ESTADO ACTIVO
					ven.setId_persona(per5.getId_persona()); 
					ven.setId_asociacion(aso.getId_asociacion());
					ven.setId_permiso(permiso.getId_permiso());
					ven.setId_puesto(puestos.getId_puesto());
					vendao.Register(ven);
					
						Productos productos2 = new Productos();
						productos2.setIdvendedor(ven.getId_vendedor());
						productos2.setNombreproducto("Pan con Hamburguesa");
						productos2.setCategoriaproducto("Panes");
						productos2.setPrecio(7.0);
						productos2.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/panhamburguesa.png");
						productos2.setId_producto(2);
						productomapper.Register(productos2);
						
					Vendedores ven2 = new Vendedores();
					ven2.setCorreo("vendedor2@yopmail.com");
					ven2.setPassword("vendedor2");
					ven2.setEstado(permiso2.isEstado());//SOLO SI TIENE PERMISO TIENE ESTADO ACTIVO
					ven2.setId_persona(per6.getId_persona()); 
					ven2.setId_asociacion(aso2.getId_asociacion());
					ven2.setId_permiso(permiso2.getId_permiso());
					ven2.setId_puesto(puestos2.getId_puesto());
					vendao.Register(ven2);
				 
						Productos productos1 = new Productos();
						productos1.setIdvendedor(ven2.getId_vendedor());
						productos1.setNombreproducto("Pan con Palta");
						productos1.setCategoriaproducto("Panes");
						productos1.setPrecio(1.0);
						productos1.setId_producto(1);
						productos1.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/panpalta.png");
						productomapper.Register(productos1);
						
						
						
						Productos productos3 = new Productos();
						productos3.setIdvendedor(ven2.getId_vendedor());
						productos3.setNombreproducto("Pan con Lomo Saltado");
						productos3.setCategoriaproducto("Panes");
						productos3.setPrecio(2.5);
						productos3.setId_producto(3);
						productos3.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/pansaltado.png");
						productomapper.Register(productos3);
						
						Productos productos4 = new Productos();
						productos4.setIdvendedor(ven2.getId_vendedor());
						productos4.setNombreproducto("Pan con Huevo");
						productos4.setCategoriaproducto("Panes");
						productos4.setPrecio(1.0);
						productos4.setId_producto(4);
						productos4.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/panhuevo.png");
						productomapper.Register(productos4);
						
						Productos productos5 = new Productos();
						productos5.setIdvendedor(ven2.getId_vendedor());
						productos5.setNombreproducto("Pan con Tamal");
						productos5.setCategoriaproducto("Panes");
						productos5.setPrecio(1.0);
						productos5.setId_producto(5);
						productos5.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/pantamal.png");
						productomapper.Register(productos5);
						
						Productos productos6 = new Productos();
						productos6.setIdvendedor(ven2.getId_vendedor());
						productos6.setNombreproducto("Pan con Huevo Tostado");
						productos6.setCategoriaproducto("Tostadas");
						productos6.setPrecio(1.5);
						productos6.setFoto("https://milleniumprogramers.s3.amazonaws.com/MunicipalidadJesusMaria/panhuevotostado.png");
						productomapper.Register(productos6);
						
					Vendedores ven3 = new Vendedores();
					ven3.setCorreo("vendedor3@yopmail.com");
					ven3.setPassword("vendedor3");
					ven3.setEstado(permiso3.isEstado());//SOLO SI TIENE PERMISO TIENE ESTADO ACTIVO
					ven3.setId_persona(per7.getId_persona()); 
					ven3.setId_asociacion(aso2.getId_asociacion());
					ven3.setId_permiso(permiso3.getId_permiso());
					ven3.setId_puesto(puestos3.getId_puesto());
					vendao.Register(ven3);
	}
	
	@Autowired
	ProductosDAO productomapper;
	
	@Autowired
	MediospagoDAO pagomapper;
	
	@Autowired
	FotospuestoDAO fotosPuestodao;*/
}
