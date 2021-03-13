package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.EstatusCategoria;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IEstatusCategoriaRepository;

@Service
public class EstatusCategoriaServiceImpl  extends BaseServiceImpl<EstatusCategoria, Integer>
implements IEstatusCategoriaService
{
	@Autowired
	private IEstatusCategoriaRepository iEstatusCategoriaRepository;
	
	public EstatusCategoriaServiceImpl(BaseRepository<EstatusCategoria, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
