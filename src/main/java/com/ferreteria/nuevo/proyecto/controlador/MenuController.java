package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Menu;
import com.ferreteria.nuevo.proyecto.servicio.IMenuService;
import com.ferreteria.nuevo.proyecto.servicio.MenuServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/menus")
public class MenuController extends BaseControllerImpl<Menu, MenuServiceImpl>
{
	@Autowired
	private IMenuService iMenuService;

}
