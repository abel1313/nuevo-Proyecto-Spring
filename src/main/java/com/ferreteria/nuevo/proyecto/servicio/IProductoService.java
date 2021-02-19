package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.web.bind.annotation.RequestBody;

import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.modelo.Proveedor;

public interface IProductoService extends IBaseService<Producto, Integer> 
{
	
	public Producto addProducto(@RequestBody Producto producto)throws Exception;
	

}
