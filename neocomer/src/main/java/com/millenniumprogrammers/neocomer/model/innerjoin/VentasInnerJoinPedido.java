package com.millenniumprogrammers.neocomer.model.innerjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentasInnerJoinPedido {

	int id_venta;
	String NombreCompleto;
	String DNI;
	String foto;
	double total;
	String FechaEmision; 
}
