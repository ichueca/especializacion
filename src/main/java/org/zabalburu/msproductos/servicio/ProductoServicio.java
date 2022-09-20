package org.zabalburu.msproductos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zabalburu.msproductos.dao.ProductoDAO;
import org.zabalburu.msproductos.modelo.Producto;

@Service
public class ProductoServicio {
	@Autowired
	private ProductoDAO dao;
	
	public Producto getProducto(Integer id) {
		return dao.getProducto(id);
	}
	
	public List<Producto> getProductos() {
		return dao.getProductos();
	}
	
	public Producto nuevoProducto(Producto p) {
		return dao.nuevoProducto(p);
	}
	
	public boolean eliminarProducto(Integer id) {
		return dao.eliminarProducto(id);
	}
	
	public boolean eliminarProducto(Producto p) {
		return dao.eliminarProducto(p.getId());
	}
	
}
