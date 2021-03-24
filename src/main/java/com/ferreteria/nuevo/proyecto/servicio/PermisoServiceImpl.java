package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Permiso;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IPermisosRepository;

@Service
public class PermisoServiceImpl extends BaseServiceImpl<Permiso, Integer> implements IPermisoService
{
	@Autowired
	private IPermisosRepository iPermisosRepository;
	
	public PermisoServiceImpl(BaseRepository<Permiso, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Integer> listPermisos( int indUsuario ) throws Exception {
		try {
			
			return iPermisosRepository.listaPermisos( indUsuario );
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

}
