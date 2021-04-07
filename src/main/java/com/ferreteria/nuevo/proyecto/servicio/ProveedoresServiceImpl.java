package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Proveedores;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IProveedoresRepository;

@Service
public class ProveedoresServiceImpl extends BaseServiceImpl<Proveedores, Integer>
implements IProveedoresService
{
	@Autowired
	private IProveedoresRepository iProveedoresRepository;
	
	public ProveedoresServiceImpl(BaseRepository<Proveedores, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
