package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Pedido;
import com.ferreteria.nuevo.proyecto.servicio.IPedidoService;
import com.ferreteria.nuevo.proyecto.servicio.PedidoServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/peidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>
{
	@Autowired
	private IPedidoService iPerIPedidoService;
	

}
