package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Permiso;
import com.ferreteria.nuevo.proyecto.servicio.IPermisoService;
import com.ferreteria.nuevo.proyecto.servicio.PermisoServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/permisos")
public class PermisoController extends BaseControllerImpl<Permiso, PermisoServiceImpl>
{
	
	@Autowired 
	private IPermisoService iPermisoService;

}
