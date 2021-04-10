package com.ferreteria.nuevo.proyecto.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.VentasPagadas;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IVentasPagadasRepository;

@Service
public class VentasPagadasServiceImpl extends BaseServiceImpl<VentasPagadas, Integer> implements IVentasPagadasService
{
	@Autowired
	private IVentasPagadasRepository iVentasPagadasRepository;
	
	public VentasPagadasServiceImpl(BaseRepository<VentasPagadas, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public VentasPagadas ventasPagadasService(int idVenta ) throws Exception {
try {
			VentasPagadas ventasx = iVentasPagadasRepository.ventasPagadas(idVenta);
	
			return ventasx;

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public VentasPagadas actualizarVenta(int idVenta, VentasPagadas ventaspagadas) throws Exception {
		try {
					VentasPagadas ventasUpdate = iVentasPagadasRepository.ventasPagadas(idVenta);
					
					System.err.println(ventasUpdate+ " venta service");
					
					Optional<VentasPagadas> ven = iVentasPagadasRepository.findById( ventasUpdate.getId() );
					
					VentasPagadas entityUpdate = ven.get();
					System.err.println(entityUpdate + " antes de ");
					entityUpdate = iVentasPagadasRepository.save(ventaspagadas);
					
					System.err.println("despues de "+ entityUpdate);
					return entityUpdate;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	

}
