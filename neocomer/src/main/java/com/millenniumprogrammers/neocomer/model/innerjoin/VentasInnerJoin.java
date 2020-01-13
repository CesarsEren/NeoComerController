package com.millenniumprogrammers.neocomer.model.innerjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VentasInnerJoin {
	int id_venta;
	String nombrecomercio;
	String foto;
	double total;
	String fechaEmision;
	String EstadoApp;

}
