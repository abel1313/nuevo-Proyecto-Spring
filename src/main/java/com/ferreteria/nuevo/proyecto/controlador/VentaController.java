package com.ferreteria.nuevo.proyecto.controlador;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.DTO.DTOVentaPagos;
import com.ferreteria.nuevo.proyecto.modelo.Cliente;
import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;
import com.ferreteria.nuevo.proyecto.modelo.Usuario;
import com.ferreteria.nuevo.proyecto.modelo.Venta;
import com.ferreteria.nuevo.proyecto.servicio.IDetalleVentaService;
import com.ferreteria.nuevo.proyecto.servicio.IVentaService;
import com.ferreteria.nuevo.proyecto.servicio.VentaServiceImpl;


@RestController
@RequestMapping(path = "/ferreteria/ventas")
public class VentaController extends BaseControllerImpl<Venta, VentaServiceImpl>
{
	
	@Autowired
	private IVentaService IVentaService;
	
	@Autowired
	private IDetalleVentaService iDetalleVentaService;
	
	@PostMapping(value = "saveVenta", produces = "application/json")	
	public ResponseEntity<?> saveV(@RequestBody Venta venta ) 
	{
		System.err.println(venta);
		return null;
	}
//	@PostMapping(value = "saveVenta", produces = "application/json")
//	
//	public ResponseEntity<?> save(@RequestBody List<DetalleVenta> detalle ) 
//	{
//System.err.println(detalle);
//		try {
//List<DetalleVenta> det = detalle.stream().filter(item-> item.getProducto().getId() != 0).collect(Collectors.toList());
//
//double totalVenta = detalle.stream()
//.filter( item-> item.getProducto().getId() != 0 )
//.mapToDouble(item -> item.getSubtotalDetalleVenta() )
//.sum();
//
//Timestamp date = new Timestamp(new java.util.Date().getTime());
//
//	Venta v = new Venta();
//	Cliente c = new Cliente();
//	Usuario u = new Usuario();
//
//			v.setTotalVenta(totalVenta);
//			v.setFechaVenta(date);
//			c.setId(3);
//			v.setCliente(c);
//			u.setId(2);
//			v.setUsuario(u);
//
//		
//			Venta newVenta = IVentaService.addVenta(v);
//
//				det.forEach( (item) -> 
//				{
//					DetalleVenta dt = item;
//					dt.setVenta(newVenta);
//					
//					DetalleVenta dye = iDetalleVentaService.addDetalle(dt);
//
//				});
//
//	
//
//			return ResponseEntity.status(HttpStatus.OK).body(newVenta);
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde'}");
//		}
//	}
//	
//	@GetMapping("buscarventaspagadas")
//	public ResponseEntity<?> newadd() 
//	{
//		
//		try {
//		List<Venta> ve = IVentaService.findAll();
//		List<DetalleVenta> de = iDetalleVentaService.findAll();
//		List<DTOVentaPagos> dtoDatos = new ArrayList<DTOVentaPagos>();
//		
//		de.forEach( item-> 
//		{
//			
//		});
//		
////		ve.forEach( item-> 
////		{
////			DTOVentaPagos dtoVentaPagos = new DTOVentaPagos();
////			
////			Cliente cl = item.getCliente();
////			Usuario us = item.getUsuario();
////			
////			
////			dtoVentaPagos.setIdVenta( item.getId() );
////			dtoVentaPagos.setTotalVenta( item.getTotalVenta() );
////			dtoVentaPagos.setFechaVenta( item.getFechaVenta().toString() );
////			dtoVentaPagos.setCliente(cl);
////			dtoVentaPagos.setUsuario(us);
////			
////			dtoDatos.add(dtoVentaPagos);
////			
////		});
//		
//		
////		for (int i = 0; i < ve.size(); i++) 
////		{
////			for (int j = 0; j < de.size(); j++) 
////			{
////				if( ve.get(i).getId() == de.get(j).getVenta().getId() )
////				{
////					DTOVentaPagos dtoVentaPagos = new DTOVentaPagos();
////					dtoVentaPagos.setIdVenta( ve.get(i).getId() );
////					dtoVentaPagos.setTotalVenta( ve.get(i).getTotalVenta() );
////				}
////				
////			}
////			
////		}
//		
//		
//		
//		
//			
//			System.err.println(ve);
//					
//			return ResponseEntity.status(HttpStatus.OK).body( dtoDatos );
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
//		}
//	}

	

}
