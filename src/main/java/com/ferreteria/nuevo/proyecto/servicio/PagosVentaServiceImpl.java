package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IPagosVentaRepository;

@Service
public class PagosVentaServiceImpl extends BaseServiceImpl<PagosVenta, Integer> implements IPagosVentaService
{

	@Autowired
	private IPagosVentaRepository iPagosVentaRepository;
	
	public PagosVentaServiceImpl(BaseRepository<PagosVenta, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<PagosVenta> listPagosVenta(int ventaId) {
		// TODO Auto-generated method stub
		return iPagosVentaRepository.findByVentaId(ventaId);
	}

	@Override
	public List<PagosVenta> listPagosVenta() {
		// TODO Auto-generated method stub
		return iPagosVentaRepository.listPagosVentas();
	}

	@Override
	public List<PagosVenta> findAllService() {
		// TODO Auto-generated method stub
		return iPagosVentaRepository.findAll();
	}

	@Override
	public List<PagosVenta> findByNombreClienteService(String nombrePersona) {
		// TODO Auto-generated method stub
		return iPagosVentaRepository.findClienteByClientePersonaNombrePersonaLike(nombrePersona);
	}

	@Override
	public List<PagosVenta> findByClienteService( @PathVariable("buscarPago") String buscarPago ) throws Exception {
		// TODO Auto-generated method stub
		try {
			return iPagosVentaRepository.findByClienteRepository( buscarPago );
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<PagosVenta> buscarPagosVentaService() throws Exception {
		try {
			return iPagosVentaRepository.findByPagosClienteRepository();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}




	

}
