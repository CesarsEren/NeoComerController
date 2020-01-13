package com.millenniumprogrammers.neocomer.service;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.millenniumprogrammers.neocomer.model.Productos;
import com.millenniumprogrammers.neocomer.model.Ventas;
import com.millenniumprogrammers.neocomer.restcontroller.parametros.InsertVenta;

public interface VentasService {

	public Map<String, Object> InsertVenta(InsertVenta insertVenta);

	public Map<String, Object> CancelarVenta(Ventas venta);

	public Map<String, Object> getHistoriaPedidos(int id_cliente);

	public Map<String, Object> getDetallePago(int id_venta);

	public Map<String, Object> Pagar(Ventas venta);

	public Map<String, Object> AceptarPedido(Ventas venta);

	public Map<String, Object> getPedidosporVendedor(int id_vendedor);
	
	public Map<String, Object> getreporte(int id_vendedor);

}
