package com.ferreteria.nuevo.proyecto.servicio;


import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.ferreteria.nuevo.proyecto.modelo.Venta;

public interface IVentaService extends IBaseService<Venta, Integer>
{

	public Venta addVenta(@RequestBody Venta v)throws Exception;
	
	public List<Venta> findByFechaInicioAndFechaFin( @PathVariable String fechaInicio, @PathVariable String fechFin ) throws Exception;	
	
	public List<Venta> findByFechaInicioAndFechaFinCliente( @PathVariable String fechaInicio, @PathVariable String fechFin, @PathVariable int id ) throws Exception;
	//public Venta addVentaIService(@RequestBody Venta v)throws Exception;
}
