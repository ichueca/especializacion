package org.zabalburu.msproductos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zabalburu.msproductos.modelo.Producto;
import org.zabalburu.msproductos.servicio.ProductoServicio;

@RestController
@RequestMapping("productos")
public class ProductoRest {
	
	@Autowired
	private ProductoServicio servicio;
	
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable Integer id){
		Producto p = servicio.getProducto(id);
		if (p!=null) {
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
