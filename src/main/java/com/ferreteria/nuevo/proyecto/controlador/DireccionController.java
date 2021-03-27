package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Direccion;
import com.ferreteria.nuevo.proyecto.servicio.DireccionServiceImpl;
import com.ferreteria.nuevo.proyecto.servicio.IDireccionService;

@RestController
@RequestMapping(path = "/ferreteria/direcciones")
public class DireccionController extends BaseControllerImpl<Direccion, DireccionServiceImpl>
{
	@Autowired
	private IDireccionService iDireccionService;
	
}
