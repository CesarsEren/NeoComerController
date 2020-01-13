package com.millenniumprogrammers.neocomer.service;

import java.util.Map;

import com.millenniumprogrammers.neocomer.model.Productos;

public interface ProductosService {

	public Map<String,Object>getProductos(Productos productos);
	public Map<String,Object>getProductosXCategoria(Productos productos);
	public Map<String,Object>RegistrarProducto(Productos pro);
	public Map<String,Object>actualizarProducto(Productos pro);
	
	
}
