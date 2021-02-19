package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calando")
public class ControlerCalad 
{
	@RequestMapping("/sa")
	public String reg()
	{
		return "BUena";
	}

}
