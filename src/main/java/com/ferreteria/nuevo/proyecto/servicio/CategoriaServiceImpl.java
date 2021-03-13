package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Categoria;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Integer> implements ICategoriaService
{
	@Autowired
	private ICategoriaRepository iCategoriaRepository;
	
	public CategoriaServiceImpl(BaseRepository<Categoria, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}
	

}
