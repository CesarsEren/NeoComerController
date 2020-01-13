package com.millenniumprogrammers.neocomer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Detalle_venta;
import com.millenniumprogrammers.neocomer.model.Ventas;
import com.millenniumprogrammers.neocomer.repository.Detalle_ventaDAO;
import com.millenniumprogrammers.neocomer.repository.VentasDAO;

import com.millenniumprogrammers.neocomer.restcontroller.parametros.InsertVenta;

@Service
public class VentasServiceImplement implements VentasService {

	@Autowired
	VentasDAO ventasmapper;

	@Autowired
	Detalle_ventaDAO detmapper;

	@Override
	public Map<String, Object> InsertVenta(InsertVenta insertVenta) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<String, Object>();
		Ventas venta = insertVenta.getCabecera();
		venta .setEstadoApp("P");
		ventasmapper.Register(venta);
		for (Detalle_venta item : insertVenta.getBody()) {
			item.setId_venta(venta.getId_venta());
			detmapper.Register(item);
		}
		rpta.put("msgserver", "SUCCESS");
		rpta.put("mensaje", "Le Notificaremos cuando su pedido sea aceptado");
		return rpta;
	}
	
	public Map<String,Object>CancelarVenta(Ventas venta)
	{
		Map<String, Object> rpta = new HashMap<String, Object>();
		ventasmapper.Cancelar(venta);
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> getHistoriaPedidos(int id_cliente) {
		Map<String, Object> rpta = new HashMap<String, Object>();
		rpta.put("ventas",ventasmapper.getHistoriaPedidos(id_cliente));		
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> getDetallePago(int id_venta) {
		Map<String, Object> rpta = new HashMap<String, Object>();
		rpta.put("cabecera",ventasmapper.cabeceraventa(id_venta));
		rpta.put("body",detmapper.SelectDetalletById(id_venta));		
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> Pagar(Ventas venta) {
		Map<String, Object> rpta = new HashMap<String, Object>();
		ventasmapper.Pagar(venta);
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> AceptarPedido(Ventas venta) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<String, Object>();
		ventasmapper.AceptarPedido(venta);
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> getPedidosporVendedor(int id_vendedor) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<String, Object>(); 
		rpta.put("pedidos",ventasmapper.getPedidosporVendedor(id_vendedor));
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> getreporte(int id_vendedor) { 
		Map<String, Object> rpta = new HashMap<String, Object>(); 
		rpta.put("reporte",ventasmapper.getreporte(id_vendedor));
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}
	
}
