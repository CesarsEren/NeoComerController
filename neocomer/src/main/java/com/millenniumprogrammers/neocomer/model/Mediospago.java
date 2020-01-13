package com.millenniumprogrammers.neocomer.model;
 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mediospago{
    
	 private int id_cliente;
	 private int id_mediopago;
	 private String NroTarjeta;
	 private String Nombre;
	 private String Apellido;
	 private String CCV;
	 private String FechaVenc;
 
 }
