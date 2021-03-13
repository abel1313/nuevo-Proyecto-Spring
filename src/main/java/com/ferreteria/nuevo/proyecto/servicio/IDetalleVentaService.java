package com.ferreteria.nuevo.proyecto.servicio;

import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;

public interface IDetalleVentaService extends IBaseService<DetalleVenta, Integer>
{
	
	public DetalleVenta addDetalle(DetalleVenta detalle);
}
