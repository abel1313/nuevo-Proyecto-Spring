package com.ferreteria.nuevo.proyecto.controlador;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.modelo.Proveedor;
import com.ferreteria.nuevo.proyecto.servicio.IProductoService;
import com.ferreteria.nuevo.proyecto.servicio.IProveedorService;
import com.ferreteria.nuevo.proyecto.servicio.ProductoServiceImpl;


@RestController
@RequestMapping(path = "/ferreteria/productos")
public class ProductoController 
extends BaseControllerImpl<Producto, ProductoServiceImpl> 
{
	@Autowired IProductoService iProductoService;
	@Autowired IProveedorService iProveedorService;
	
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
	public ResponseEntity<?> guardarProducto(@PathVariable("codigo") String codigo) {
		try {
			System.err.println("Codigo barra "+ codigo);
			return ResponseEntity.status(HttpStatus.OK).body(iProductoService.codigoBarra(codigo));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	@PostMapping(path = "/buscarCodigoEditar")
	public ResponseEntity<?> existsCodigoBarrasEditar(@RequestBody Producto productoEditar) {
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(iProductoService.existsCodigoBarraEditar( productoEditar.getCodigoBarrasProducto(), productoEditar.getId() ) );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	@PutMapping(path = "/editarProducto")
	public ResponseEntity<?> editarProducto(@RequestBody Producto productoEditar) {
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(iProductoService.updateProducto( productoEditar ) );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	
	@GetMapping(path = "/buscarProductos/{codigo}")
	public ResponseEntity<?> buscarProductoByCodigoOrNombre(@PathVariable("codigo") String codigo) {
		try {
			
			if(codigo.equals("1"))
			{
				System.err.println("Entro en 1");
				return ResponseEntity.status(HttpStatus.OK).body(iProductoService.findAll());
			}else
			{
				System.err.println("Entro en 0");
				return ResponseEntity.status(HttpStatus.OK).body(iProductoService.buscarByCodigoOrNombreService(codigo));
			}
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	
	
	

}

