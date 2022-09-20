package org.zabalburu.msproductos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("")
	public List<Producto> getProductos(){
		return servicio.getProductos();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> nuevoProducto(@RequestBody Producto p) throws Exception{
		if (p.getNombre()== null || p.getNombre().isEmpty()) {
			return ResponseEntity.unprocessableEntity().body(new Exception("Falta el nombre"));
		} else {
			Producto nuevo = servicio.nuevoProducto(p);
			return ResponseEntity.created(new URI("/productos/"+nuevo.getId())).body(nuevo);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Integer id){
		servicio.eliminarProducto(id);
		return ResponseEntity.ok().build();
	}
}
