package org.zabalburu.msproductos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Producto {
	@EqualsAndHashCode.Include
	private Integer id;
	private String nombre;
	private Double precio;
}
