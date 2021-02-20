package com.ferreteria.nuevo.proyecto.controlador;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.modelo.Proveedor;
import com.ferreteria.nuevo.proyecto.servicio.IProductoService;
import com.ferreteria.nuevo.proyecto.servicio.ProductoServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/productos")
public class ProductoController 
extends BaseControllerImpl<Producto, ProductoServiceImpl> 
{
	@Autowired IProductoService iProductoService;
	
	@PostMapping(path = "/guardarProducto")
	public ResponseEntity<?> guardarProducto(@RequestBody Producto  producto) {
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(iProductoService.addProducto(producto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	@GetMapping(path = "/buscarCodigo/{codigo}")
	public ResponseEntity<?> guardarProducto(@PathParam("codigo") String codigo) {
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(iProductoService.addProducto(producto));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	

}

