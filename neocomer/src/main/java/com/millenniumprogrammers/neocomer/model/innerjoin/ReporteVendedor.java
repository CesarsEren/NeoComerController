package com.millenniumprogrammers.neocomer.model.innerjoin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReporteVendedor {

	int id_vendedor;
	int clientes;
	double gananciaTotal;
	double gananciaHoy;
}
