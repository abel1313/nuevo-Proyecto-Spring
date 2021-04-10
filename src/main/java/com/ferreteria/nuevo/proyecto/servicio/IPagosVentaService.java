package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;

public interface IPagosVentaService extends IBaseService<PagosVenta, Integer>
{
	public List<PagosVenta> listPagosVenta(int ventaId);
	
	public List<PagosVenta> listPagosVenta();
	
	public List<PagosVenta> findAllService();
	
	
	public List<PagosVenta> findByNombreClienteService( String nombrePersona);
	
	public List<PagosVenta> findByClienteService(@PathVariable("buscarPago") String buscarPago ) throws Exception;
	
	
	public List<PagosVenta> buscarPagosVentaService() throws Exception;
	


}
