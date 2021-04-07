package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Proveedores;
import com.ferreteria.nuevo.proyecto.servicio.ProveedoresServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/proveedoress")
public class ProveedoresController extends BaseControllerImpl<Proveedores, ProveedoresServiceImpl>
{

}
