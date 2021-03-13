package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Usuario;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IUsuarioRepository;

@Service
public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> implements IUsuarioService
{

	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	public UsuarioServiceImpl(BaseRepository<Usuario, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
