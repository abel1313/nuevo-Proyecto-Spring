package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Marcas;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IMarcasReporitory;

@Service
public class MarcasServiceImpl extends BaseServiceImpl<Marcas, Integer> implements IMarcasServiceç
{
	@Autowired
	private IMarcasReporitory iMarcasReporitory;
	public MarcasServiceImpl(BaseRepository<Marcas, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
