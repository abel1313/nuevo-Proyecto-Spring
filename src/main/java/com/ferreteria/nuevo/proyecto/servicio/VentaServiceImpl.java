package com.ferreteria.nuevo.proyecto.servicio;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

	@Override
	public List<Venta> findByFechaInicioAndFechaFin( @PathVariable String fechaInicio, @PathVariable String fechFin ) throws Exception {
		try {
			
			return iVentaRepository.findByFechaInicioAndFechaFin( fechaInicio, fechFin );
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Venta> findByFechaInicioAndFechaFinCliente(String fechaInicio, String fechFin, int id)
			throws Exception {
		try {
			
			return iVentaRepository.findByFechaInicioAndFechaFinCliente(fechaInicio, fechFin, id);
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
