package com.ferreteria.nuevo.proyecto.servicio;

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



}
