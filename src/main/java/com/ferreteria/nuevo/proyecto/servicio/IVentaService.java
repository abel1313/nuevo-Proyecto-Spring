package com.ferreteria.nuevo.proyecto.servicio;


import org.springframework.web.bind.annotation.RequestBody;


import com.ferreteria.nuevo.proyecto.modelo.Venta;

public interface IVentaService extends IBaseService<Venta, Integer>
{

	public Venta addVenta(@RequestBody Venta v)throws Exception;
	
	//public Venta addVentaIService(@RequestBody Venta v)throws Exception;
}
