package com.ferreteria.nuevo.proyecto.controlador;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;
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

			
			return  ResponseEntity.status(HttpStatus.OK).body(iVentasPagadasService .save(ventasPagadas));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
}
