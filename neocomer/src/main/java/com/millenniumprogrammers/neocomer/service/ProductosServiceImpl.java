package com.millenniumprogrammers.neocomer.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.millenniumprogrammers.neocomer.model.Productos;
import com.millenniumprogrammers.neocomer.repository.ProductosDAO;

@Service
public class ProductosServiceImpl implements ProductosService{
	
	@Autowired
	ProductosDAO productosdao;

	@Override
	public Map<String, Object> getProductos(Productos productos) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();
		rpta.put("productos", productosdao.SelectByIdVendedor(productos));
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> getProductosXCategoria(Productos productos) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();
		rpta.put("productos", productosdao.SelectByIdVendedorAndCategoria(productos));
		rpta.put("msgserver", "SUCCESS");
		return rpta;
		
	}

	@Override
	public Map<String, Object> RegistrarProducto(Productos pro) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();
		productosdao.Register(pro);
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

	@Override
	public Map<String, Object> actualizarProducto(Productos pro) {
		// TODO Auto-generated method stub
		Map<String, Object> rpta = new HashMap<>();
		productosdao.Update(pro);
		rpta.put("msgserver", "SUCCESS");
		return rpta;
	}

}
