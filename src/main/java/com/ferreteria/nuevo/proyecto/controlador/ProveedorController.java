package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Proveedor;

import com.ferreteria.nuevo.proyecto.servicio.ProveedorServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/proveedores")
public class ProveedorController extends BaseControllerImpl<Proveedor, ProveedorServiceImpl>{

}