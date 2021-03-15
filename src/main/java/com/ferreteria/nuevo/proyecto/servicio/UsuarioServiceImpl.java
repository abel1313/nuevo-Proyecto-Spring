package com.ferreteria.nuevo.proyecto.servicio;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

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

	@Override
	public Usuario addUsuarioService(Usuario us) throws Exception {

		try {
			
			return iUsuarioRepository.save( us );
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	
	}

	@Override
	public Usuario findByUsuarioAndContraService(String usuario, String contra) throws Exception {
		try {
			
			return iUsuarioRepository.findByNombre_UsuarioAndContra_Usuario(usuario, contra);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Page<Usuario> findAll(org.springframework.data.domain.Pageable pageable)throws Exception {

		try {
			
			return iUsuarioRepository.findAll(pageable);
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Boolean existsUsuarioService(String usuario) throws Exception {
		try {
			
			int existe = iUsuarioRepository.existUsuario(usuario);
			System.err.println(existe + " cuantos ahi");
			return ( existe > 0 ) ? true : false ;
			
			
		} catch (Exception e) 
		{
			
			throw new Exception(e.getMessage());
		}
	}



}
