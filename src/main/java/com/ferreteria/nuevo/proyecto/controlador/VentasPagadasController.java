package com.ferreteria.nuevo.proyecto.controlador;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.VentasPagadas;
import com.ferreteria.nuevo.proyecto.servicio.IVentasPagadasService;
import com.ferreteria.nuevo.proyecto.servicio.VentasPagadasServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/ventaspagadas")
public class VentasPagadasController extends BaseControllerImpl<VentasPagadas, VentasPagadasServiceImpl>
{

	@Autowired
	private IVentasPagadasService iVentasPagadasService;
	
	@PostMapping("guardarventapagada")
	public ResponseEntity<?> savePago(@RequestBody VentasPagadas ventasPagadas) {
		try {

		System.err.println(ventasPagadas + " ventapagada");
		System.err.println(ventasPagadas.getEstatusVenta().getId() + " estatus");
		
		System.err.println(ventasPagadas.getVenta().getId() + " venta");
	// 	Timestamp date = new Timestamp(new java.util.Date().getTime());

			
			return  ResponseEntity.status(HttpStatus.OK).body(iVentasPagadasService.save(ventasPagadas));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	@PutMapping("actualizarpago/{id}")
	public ResponseEntity<?> actualizarpago( @PathVariable("id") int id ,@RequestBody VentasPagadas ventasPagadas) {
		try {

		
		VentasPagadas ventaPagada = iVentasPagadasService.ventasPagadasService( id );
		System.err.println(ventaPagada, " venta controller");
		 
		VentasPagadas ventaUpdate = iVentasPagadasService.actualizarVenta( ventaPagada.getId(), ventasPagadas);
		
		return  ResponseEntity.status(HttpStatus.OK).body( ventaUpdate );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
	
}
