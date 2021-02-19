package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Persona;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IPersonaRepository;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona, Integer> 
implements IPersonaService
{

	@Autowired
	private IPersonaRepository iPersonaRepository;
	
	public PersonaServiceImpl(BaseRepository<Persona, Integer> baseRepository) {
		super(baseRepository);
	}

	

}
