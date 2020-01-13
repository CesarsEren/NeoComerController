package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ubicaciones{
    
	 private int id_cliente;
	 private String Apodo;
	 private double longitud;
	 private double latitud;
	 private String direccion;
 
 }
