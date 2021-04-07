package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Marcas;
import com.ferreteria.nuevo.proyecto.servicio.IMarcasServiceç;
import com.ferreteria.nuevo.proyecto.servicio.MarcasServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/marcass")
public class MarcasController extends BaseControllerImpl<Marcas, MarcasServiceImpl>
{
	@Autowired
	private IMarcasServiceç iMarcasServiceç;

}
