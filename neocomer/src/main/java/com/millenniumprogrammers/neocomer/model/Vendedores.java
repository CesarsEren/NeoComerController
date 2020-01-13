package com.millenniumprogrammers.neocomer.model;
 
import java.util.Collection;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedores{
    
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1865774513806896929L;
	
	private int id_vendedor;
	 private int id_persona;
	 private int id_asociacion;
	 private int id_permiso;
	 private String correo;
	 private String password;
	 private boolean estado;
	 private int id_puesto;
  }
