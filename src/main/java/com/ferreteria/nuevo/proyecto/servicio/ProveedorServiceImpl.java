package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Proveedor;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IProveedorRepository;

@Service
public class ProveedorServiceImpl extends BaseServiceImpl<Proveedor, Integer>
implements IProveedorService
{

	@Autowired
	private IProveedorRepository iProveedorRepository;
	
	public ProveedorServiceImpl(BaseRepository<Proveedor, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
