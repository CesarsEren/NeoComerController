package com.millenniumprogrammers.neocomer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detalle_venta {
 
	int id_venta;
	int id_producto;
	String nombreproducto;
	double precioproducto;
	String fotoproducto;
	int cantidad;

}
