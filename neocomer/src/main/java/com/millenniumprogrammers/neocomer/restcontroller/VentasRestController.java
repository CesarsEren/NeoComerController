package com.millenniumprogrammers.neocomer.restcontroller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.millenniumprogrammers.neocomer.model.Detalle_venta;
import com.millenniumprogrammers.neocomer.model.Ventas;

import com.millenniumprogrammers.neocomer.restcontroller.parametros.InsertVenta;
import com.millenniumprogrammers.neocomer.service.VentasService;

@RestController
@RequestMapping("Ventas")
public class VentasRestController {

	@Autowired
	VentasService ventas;

	@PostMapping("/insertar")
	public Map<String, Object> InsertVenta(@RequestBody InsertVenta Venta) {
		return ventas.InsertVenta(Venta);
	}

	@PutMapping("/cancelar")
	public Map<String, Object> CancelarVenta(@RequestBody Ventas venta) {
		return ventas.CancelarVenta(venta);
	}

	@PutMapping("/pagar")
	public Map<String, Object> PagarVenta(@RequestBody Ventas venta) {
		return ventas.Pagar(venta);
	}

	@PutMapping("/aceptar")
	public Map<String, Object> AceptarPedido(@RequestBody Ventas venta) {
		return ventas.AceptarPedido(venta);
	}

	@GetMapping("/getHistoriaPedidos/{id_cliente}")
	public Map<String, Object> getHistoriaPedidos(@PathVariable("id_cliente") int id_cliente) {
		return ventas.getHistoriaPedidos(id_cliente);
	}

	// Vendedor
	@GetMapping("getPedidosporVendedor/{id_vendedor}")
	public Map<String, Object> getPedidosporVendedor(@PathVariable("id_vendedor") int id_vendedor) {
		return ventas.getPedidosporVendedor(id_vendedor);
	}

	@GetMapping("getreporte/{id_vendedor}")
	public Map<String, Object> getreporte(@PathVariable("id_vendedor") int id_vendedor) {
		return ventas.getreporte(id_vendedor);
	}

	@GetMapping("/getdetalle/{id_venta}")
	public Map<String, Object> getDetallepago(@PathVariable("id_venta") int id_venta) {
		return ventas.getDetallePago(id_venta);
	}

	/*
	 * @GetMapping("lista/{id_vendedor}") public Map<String, Object>
	 * getProductos(@PathVariable("id_vendedor") int id_vendedor) { Productos pr =
	 * new Productos(); pr.setIdvendedor(id_vendedor); return
	 * prodservice.getProductos(pr); }
	 */

}
