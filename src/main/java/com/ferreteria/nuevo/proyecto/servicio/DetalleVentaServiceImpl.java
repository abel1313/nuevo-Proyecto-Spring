package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;

@Service
public class DetalleVentaServiceImpl extends BaseServiceImpl<DetalleVenta, Integer> 
implements IDetalleVentaService
{

	public DetalleVentaServiceImpl(BaseRepository<DetalleVenta, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}



}
