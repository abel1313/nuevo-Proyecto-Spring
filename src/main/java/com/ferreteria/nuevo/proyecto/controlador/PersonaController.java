package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Persona;
import com.ferreteria.nuevo.proyecto.servicio.PersonaServiceImpl;


@RestController
@RequestMapping(path = "/ferreteria/person")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl>{

}
