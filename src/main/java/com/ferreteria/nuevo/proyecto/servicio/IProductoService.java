package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.modelo.Proveedor;

public interface IProductoService extends IBaseService<Producto, Integer> 
{
	
	public Producto addProducto(@RequestBody Producto producto)throws Exception;
	
	public boolean codigoBarra(@PathVariable String codigo)throws Exception;
	
	public boolean existsCodigoBarraEditar(@PathVariable String codigo, @PathVariable int idProducto)throws Exception;
	
	public List<Producto> buscarByCodigoOrNombreService(@PathVariable String codigo)throws Exception;
	
	public Producto updateProducto(@RequestBody Producto producto)throws Exception;
	

}
