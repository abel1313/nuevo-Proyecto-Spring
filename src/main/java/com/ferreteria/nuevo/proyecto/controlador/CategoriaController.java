package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Categoria;
import com.ferreteria.nuevo.proyecto.servicio.CategoriaServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/categorias")
public class CategoriaController extends BaseControllerImpl<Categoria, CategoriaServiceImpl>
{

}
