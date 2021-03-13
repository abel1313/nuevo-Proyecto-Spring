package com.ferreteria.nuevo.proyecto.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Venta;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IVentaRepository;

@Service
public class VentaServiceImpl extends BaseServiceImpl<Venta, Integer>
implements IVentaService
{
	
	@Autowired
	private IVentaRepository iVentaRepository;

	public VentaServiceImpl(BaseRepository<Venta, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Venta addVenta(Venta v) throws Exception {
		try {
			return iVentaRepository.save(v);
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

//	@Override
//	public Venta addVentaIService(Venta v) throws Exception {
//		try {
//			return iVentaRepository.addVentaIRepository(v.getFechaVenta(),v.getTotalVenta(), v.getCliente().getId(), v.getCliente().getId());
//			
//		} catch (Exception e) {
//			
//			throw new Exception(e.getMessage());
//		}
//	}

	
	
}
