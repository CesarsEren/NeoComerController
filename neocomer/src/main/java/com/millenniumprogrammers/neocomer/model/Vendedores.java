package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vendedores{
    
	 private int id_vendedor;
	 private int id_persona;
	 private int id_asociacion;
	 private int id_permiso;
	 private String correo;
	 private String password;
	 private boolean estado;
	 private int id_puesto;
 
 }
