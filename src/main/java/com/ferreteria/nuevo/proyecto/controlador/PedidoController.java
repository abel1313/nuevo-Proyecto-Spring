package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Pedido;
import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.servicio.IPedidoService;
import com.ferreteria.nuevo.proyecto.servicio.PedidoServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>
{
	@Autowired
	private IPedidoService iPedidoService;
	
	@PostMapping(path = "/guardarPedido")
	public ResponseEntity<?> guardarProducto(@RequestBody Pedido  pedido) {
		try {
			System.err.println(pedido+ " pedido");
			return ResponseEntity.status(HttpStatus.OK).body(iPedidoService.save(pedido));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}

}
