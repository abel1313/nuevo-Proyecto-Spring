package com.ferreteria.nuevo.proyecto.controlador;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.DTO.DTOPagoReporte;
import com.ferreteria.nuevo.proyecto.DTO.DTOVentaPagos;
import com.ferreteria.nuevo.proyecto.modelo.Cliente;
import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;
import com.ferreteria.nuevo.proyecto.modelo.Usuario;
import com.ferreteria.nuevo.proyecto.modelo.Venta;
import com.ferreteria.nuevo.proyecto.modelo.VentasPagadas;
import com.ferreteria.nuevo.proyecto.servicio.IPagosVentaService;
import com.ferreteria.nuevo.proyecto.servicio.IVentaService;
import com.ferreteria.nuevo.proyecto.servicio.IVentasPagadasService;
import com.ferreteria.nuevo.proyecto.servicio.PagosVentaServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/pagosventa")
public class PagosVentaController extends BaseControllerImpl<PagosVenta, PagosVentaServiceImpl>
{
	@Autowired
	private IPagosVentaService iPagosVentaService;

	@Autowired
	private IVentaService iVentaService;
	
	@Autowired
	private IVentasPagadasService IVentasPagadasService;
	
	
	@PostMapping("guardarPago")
	public ResponseEntity<?> savePago(@RequestBody PagosVenta pago) {
		try {
//			PagosVenta pagosVenta = (PagosVenta) iPagosVentaService.save(entity);
//			
//			List<PagosVenta> listaPagos = iPagosVentaService.findAll();
//			
//		List<PagosVenta> listResPagosVenta = listaPagos.stream()
//				.filter( item -> entity.getVenta().getId() == item.getVenta().getId() )
//					.collect( Collectors.toList() );
//		
//		double sumRes = listaPagos.stream().filter( item -> entity.getVenta().getId() == item.getVenta().getId() )
//				.mapToDouble( item -> item.getPagoVenta() )
//				.sum();
//		
		Timestamp date = new Timestamp(new java.util.Date().getTime());
		pago.setFechaPago(date);
		PagosVenta pagoVenta = iPagosVentaService .save(pago);
		
		List<PagosVenta> listaPagoReporte =  iPagosVentaService.findAll();
		
		double totalPagosReporte = listaPagoReporte.stream().filter( item-> item.getVenta().getId() == pagoVenta.getVenta().getId() )
				.mapToDouble( item-> item.getPagoVenta() )
				.sum();
		
		Venta ventaReporte = iVentaService.findById(pagoVenta.getVenta().getId());
		

		double adeudoReporte = ventaReporte.getTotalVenta() - totalPagosReporte;
		
		DTOPagoReporte  dtoPagoReporte = new DTOPagoReporte();
		Cliente cli = ventaReporte.getCliente();
		String nombreCliente = cli.getPersona().getNombrePersona() + " " + cli.getPersona().getPaternoPersona() +" "+ cli.getPersona().getMaternoPersona();
		dtoPagoReporte.setTotalVenta( ventaReporte.getTotalVenta() );
		dtoPagoReporte.setPagoRealizado( pagoVenta.getPagoVenta() );
		dtoPagoReporte.setAdeudo( adeudoReporte );
		dtoPagoReporte.setNombreCliente( nombreCliente );
		dtoPagoReporte.setFechaDeposito( ventaReporte.getFechaVenta().toString() );
		dtoPagoReporte.setTotalPagos(totalPagosReporte);
		
			
			return  ResponseEntity.status(HttpStatus.OK).body(dtoPagoReporte);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
	
	
	
	@GetMapping("mostrarpagosventa")
	public ResponseEntity<?> mostrarPagos() {
		try {
		Timestamp date = new Timestamp(new java.util.Date().getTime());
		List<Venta> listVentas = iVentaService.findAll();
		
		List<PagosVenta> listPagosVentaTotal = iPagosVentaService.findAll();
		
		List<PagosVenta> listPagosVentas = iPagosVentaService.listPagosVenta();
		List<DTOVentaPagos> dtoVentasPagos = new ArrayList<DTOVentaPagos>();
		listPagosVentas.forEach( item-> 
		{
			double totalPago = listPagosVentaTotal.
					stream().
					filter( itemFilter-> item.getVenta().getId() == itemFilter.getVenta().getId() )
					.mapToDouble( PagosVenta::getPagoVenta )
					.sum();
			
			if( totalPago < item.getVenta().getTotalVenta() )
			{
				DTOVentaPagos dtoVentaPagos = new DTOVentaPagos();
				Cliente c = item.getVenta().getCliente();
				Usuario u = item.getVenta().getUsuario();
				
				dtoVentaPagos.setIdVenta( item.getVenta().getId() );
				dtoVentaPagos.setTotalPagosVenta(totalPago);
				dtoVentaPagos.setTotalVenta( item.getVenta().getTotalVenta() );
				dtoVentaPagos.setTotalResta( dtoVentaPagos.getTotalVenta() - dtoVentaPagos.getTotalPagosVenta()  );
				
				dtoVentaPagos.setFechaVenta( item.getVenta().getFechaVenta().toString() );
				dtoVentaPagos.setCliente( c );
				dtoVentaPagos.setUsuario( u );
				dtoVentasPagos.add(dtoVentaPagos);
				
			}

			
		});
		List<VentasPagadas> ventasPagadas = IVentasPagadasService.findAll();
			
//		return  ResponseEntity.status(HttpStatus.OK).body( dtoVentasPagos );
			return  ResponseEntity.status(HttpStatus.OK).body( dtoVentasPagos );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
	
	@GetMapping("buscarcliente/{nombrecliente}")
	public ResponseEntity<?> mostrarcliente( @PathVariable("nombrecliente") String nombreCliente ) {
		try {
		Timestamp date = new Timestamp(new java.util.Date().getTime());
		System.err.println(nombreCliente + " Nombre cliente");
		List<PagosVenta> listPagos = iPagosVentaService.findByNombreClienteService(nombreCliente);


			
//		return  ResponseEntity.status(HttpStatus.OK).body( dtoVentasPagos );
			return  ResponseEntity.status(HttpStatus.OK).body( listPagos );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	

}







