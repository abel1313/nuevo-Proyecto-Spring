package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;
import com.ferreteria.nuevo.proyecto.servicio.DetalleVentaServiceImpl;
import com.ferreteria.nuevo.proyecto.servicio.IDetalleVentaService;

@RestController
@RequestMapping(path = "/ferreteria/Detalle")
public class DetalleVentaController extends BaseControllerImpl<DetalleVenta, DetalleVentaServiceImpl> 
{

	@Autowired
	private IDetalleVentaService iDetalleVentaService;
	
}
