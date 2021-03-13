package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IDetalleVentaRepository;

@Service
public class DetalleVentaServiceImpl extends BaseServiceImpl<DetalleVenta, Integer> 
implements IDetalleVentaService
{

	@Autowired
	private IDetalleVentaRepository iDetalleVentaRepository;
	
	public DetalleVentaServiceImpl(BaseRepository<DetalleVenta, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public DetalleVenta addDetalle(DetalleVenta detalle) 
	{
		
		DetalleVenta  dtx = iDetalleVentaRepository.save(detalle);
		
		return dtx; 
	}



}
