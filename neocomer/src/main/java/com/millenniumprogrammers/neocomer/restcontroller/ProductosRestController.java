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

import com.millenniumprogrammers.neocomer.model.Productos;
import com.millenniumprogrammers.neocomer.service.ProductosService;

@RestController
@RequestMapping("Productos")
public class ProductosRestController {

	@Autowired
	ProductosService prodservice;

	@GetMapping("lista/{id_vendedor}")
	public Map<String, Object> getProductos(@PathVariable("id_vendedor") int id_vendedor) {
		Productos pr = new Productos();
		pr.setIdvendedor(id_vendedor);
		return prodservice.getProductos(pr);
	}

	@GetMapping("lista/{id_vendedor}/{categoriaproducto}")
	public Map<String, Object> getProductosXCategoria(@PathVariable("id_vendedor") int id_vendedor,
			@PathVariable("categoriaproducto") String categoriaproducto) {
		Productos pr = new Productos();
		pr.setIdvendedor(id_vendedor);
		pr.setCategoriaproducto(categoriaproducto);
		return prodservice.getProductosXCategoria(pr);
	}

	@PostMapping("agregar")
	public Map<String, Object> Addproducto(@RequestBody Productos pro) {
		return prodservice.RegistrarProducto(pro);
	}

	@PutMapping("actualizar")
	public Map<String, Object> actualizarProducto(@RequestBody Productos pro) {
		return prodservice.actualizarProducto(pro);
	}

}
