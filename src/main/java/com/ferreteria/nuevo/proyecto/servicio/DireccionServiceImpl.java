package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Direccion;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IDireccionRepository;

@Service
public class DireccionServiceImpl extends BaseServiceImpl<Direccion, Integer> implements IDireccionService
{
	@Autowired
	private IDireccionRepository iDireccionRepository;

	public DireccionServiceImpl(BaseRepository<Direccion, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
