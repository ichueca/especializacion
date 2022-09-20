package org.zabalburu.msproductos.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.zabalburu.msproductos.modelo.Producto;

@Repository
public class ProductoDAO {
	private List<Producto> productos = new ArrayList<Producto>();
	
	public ProductoDAO() {
		productos.add(new Producto(1,"Producto 1",123.50));
		productos.add(new Producto(2,"Producto 2",200.75));
		productos.add(new Producto(3,"Producto 3",90.45));
		productos.add(new Producto(4,"Producto 4",108.50));
	}
	
	public Producto getProducto(Integer id) {
		return productos.stream().filter(p -> p.getId().equals(id)).findAny().orElse(null);
	}
	
	public List<Producto> getProductos() {
		return productos;
	}
	
	public Producto nuevoProducto(Producto p) {
		Integer id = productos.isEmpty() ? 1 : productos.get(productos.size()-1).getId()+1;
		p.setId(id);
		productos.add(p);
		return p;
	}
	
	public boolean eliminarProducto(Integer id) {
		Producto p = getProducto(id);
		if (p != null) {
			productos.remove(p);
			return true;
		}
		return false;
	}
}
