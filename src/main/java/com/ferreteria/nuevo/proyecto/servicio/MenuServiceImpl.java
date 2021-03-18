package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Menu;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IMenuRepository;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, Integer> implements IMenuService
{

	@Autowired
	private IMenuRepository iMenuRepository;
	
	public MenuServiceImpl(BaseRepository<Menu, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
