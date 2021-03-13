package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.EstatusCategoria;
import com.ferreteria.nuevo.proyecto.servicio.EstatusCategoriaServiceImpl;
import com.ferreteria.nuevo.proyecto.servicio.IEstatusCategoriaService;

@RestController
@RequestMapping(path = "/ferreteria/estatuscategoria")
public class EstatusCategoriaController extends BaseControllerImpl<EstatusCategoria, EstatusCategoriaServiceImpl>
{
	@Autowired
	private IEstatusCategoriaService iEstatusCategoriaService;
	

}
