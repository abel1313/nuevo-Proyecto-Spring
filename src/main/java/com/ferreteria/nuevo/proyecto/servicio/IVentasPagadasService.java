package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ferreteria.nuevo.proyecto.modelo.VentasPagadas;

public interface IVentasPagadasService extends IBaseService<VentasPagadas, Integer>
{
	
	public VentasPagadas ventasPagadasService( @PathVariable("idVenta") int idVenta) throws Exception;
	
	public VentasPagadas actualizarVenta( @PathVariable("idVenta") int idVenta, @RequestBody VentasPagadas ventaspagadas ) throws Exception;

}
