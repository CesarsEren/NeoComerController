package com.millenniumprogrammers.neocomer.model.innerjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbicacionesInnerJoin {
	
	int id_vendedor;
	String Detalle;
	String Referencia;
	String Apodo;
	double Longitud;
	double Latitud;
	String foto;
	double preciopromedio;

}
