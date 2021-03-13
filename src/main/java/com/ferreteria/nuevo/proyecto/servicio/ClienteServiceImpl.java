package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Cliente;
import com.ferreteria.nuevo.proyecto.modelo.Persona;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IClienteRepository;
import com.ferreteria.nuevo.proyecto.repository.IPersonaRepository;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Integer> implements IServiceCliente
{
	@Autowired
	private IClienteRepository iClienteRepository;
	@Autowired
	private IPersonaRepository iPersonaRepository;

	public ClienteServiceImpl(BaseRepository<Cliente, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cliente> buscarClientesService() {
		// TODO Auto-generated method stub
		return iClienteRepository.findAll();
	}

	@Override
	public List<Cliente> findClienteByNombreService(String nombrePersona) throws Exception 
	{
			if( !nombrePersona.equals(""))
			{
				return iClienteRepository.findByNombreClienteLike(nombrePersona);
			}
			return null;
	}

	@Override
	public Cliente updateCliente(Integer id, Cliente cli) throws Exception 
	{
		
		
		iPersonaRepository.deleteById(cli.getPersona().getId());
		Persona p = iPersonaRepository.save(cli.getPersona());
		Cliente c = new Cliente();
		c.setId(id);
		c.setPersona(p);
		Cliente obtenerClientente = iClienteRepository.save( c );
		
		return iClienteRepository.save(obtenerClientente);
	}

}
