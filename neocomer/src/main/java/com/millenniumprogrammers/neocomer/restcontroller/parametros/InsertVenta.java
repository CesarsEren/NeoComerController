package com.millenniumprogrammers.neocomer.restcontroller.parametros;

import java.util.List;

import com.millenniumprogrammers.neocomer.model.Detalle_venta;
import com.millenniumprogrammers.neocomer.model.Ventas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertVenta {
	
	Ventas cabecera;
	List<Detalle_venta> body;

}
