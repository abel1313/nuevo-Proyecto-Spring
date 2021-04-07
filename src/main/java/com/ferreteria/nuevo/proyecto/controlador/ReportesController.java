package com.ferreteria.nuevo.proyecto.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ferreteria.nuevo.proyecto.DTO.DTOPagoReporte;
import com.ferreteria.nuevo.proyecto.DTO.DTOReportesPagos;
import com.ferreteria.nuevo.proyecto.DTO.DTOReportesVentas;
import com.ferreteria.nuevo.proyecto.DTO.DTOVentaPago;
import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;
import com.ferreteria.nuevo.proyecto.modelo.Persona;
import com.ferreteria.nuevo.proyecto.modelo.Venta;
import com.ferreteria.nuevo.proyecto.modelo.VentasPagadas;
import com.ferreteria.nuevo.proyecto.servicio.IPagosVentaService;
import com.ferreteria.nuevo.proyecto.servicio.IVentaService;
import com.ferreteria.nuevo.proyecto.servicio.IVentasPagadasService;

@RestController
@RequestMapping(path = "/ferreteria/reportes")
public class ReportesController 
{
	@Autowired
	private IVentaService iVentaService;
	
	@Autowired
	private IPagosVentaService iPagosVentaService;
	
	@Autowired
	private IVentasPagadasService iVentasPagadasService;
	
	@GetMapping(path = "/ventas/{inicio}/{fin}")
	public ResponseEntity<?> obtenerReportesVenta( @PathVariable("inicio") String inicio, @PathVariable("fin") String fin )
	{
		try {

			List<Venta> listaVentas = iVentaService.findByFechaInicioAndFechaFin(inicio, fin);
			List<DTOReportesVentas> listDTOReporteVenta = new ArrayList<DTOReportesVentas>();
			
			listaVentas.stream().forEach( item-> 
			{
				DTOReportesVentas dtoReportesVentas = new DTOReportesVentas();
				Persona per = item.getCliente().getPersona();
				dtoReportesVentas.setTotalVenta( item.getTotalVenta() );
				dtoReportesVentas.setNombreCliente( per.getNombrePersona() +" "+ per.getPaternoPersona() +" "+ per.getMaternoPersona() );
				dtoReportesVentas.setFechaVenta( item.getFechaVenta().toString() );
				listDTOReporteVenta.add(dtoReportesVentas);

			});
			
			return ResponseEntity.status(HttpStatus.OK).body( listDTOReporteVenta );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}	
	}
	
	// 
	@GetMapping(path = "/pagos/{inicio}/{fin}/{idCliente}")
	public ResponseEntity<?> obtenerReportesPagos( @PathVariable("inicio") String inicio, @PathVariable("fin") String fin,
			@PathVariable("idCliente") int idCliente )
	{
		try {

			List<Venta> listaVentasClientes = iVentaService.findByFechaInicioAndFechaFinCliente( inicio, fin, idCliente );
			List<DTOPagoReporte> listDTOPagoReporte = new ArrayList<DTOPagoReporte>();
			listaVentasClientes.forEach( itemVentas ->
			{
				DTOPagoReporte dTOPagoReporte = new DTOPagoReporte();
				Persona personaCliente = itemVentas.getCliente().getPersona();
					dTOPagoReporte.setId( itemVentas.getId() );
				dTOPagoReporte.setTotalVenta( itemVentas.getTotalVenta() );
				dTOPagoReporte.setNombreCliente( personaCliente.getNombrePersona() +" "+ personaCliente.getPaternoPersona()+" "+ personaCliente.getMaternoPersona() );
				dTOPagoReporte.setFechaDeposito( itemVentas.getFechaVenta().toString() );
				listDTOPagoReporte.add(dTOPagoReporte);
				
			});
			
			
			return ResponseEntity.status(HttpStatus.OK).body( listDTOPagoReporte );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}	
	}

	
	// estamos aqui
	@GetMapping(path = "/pagosclientes/{idVenta}")
	public ResponseEntity<?> obtenerReportesPagosClientes( @PathVariable("idVenta") int idVenta )
	{
		try {

			
			List<VentasPagadas> ventasPagadas = iVentasPagadasService.findAll();
			
			boolean bolCalando = ventasPagadas.stream().filter( ite-> ite.getVenta().getId() == idVenta ).findFirst().isPresent();
			
			DTOReportesPagos pagosServer = new DTOReportesPagos();
			
			if( bolCalando )
			{
				
			}else
			{
				List<PagosVenta> listaPagos= iPagosVentaService.findAll();
				List<PagosVenta> listaPagosRealizados = listaPagos
						.stream()
						.filter( it-> it.getVenta().getId() == idVenta )
						.collect( Collectors.toList() );
	
				pagosServer.setVenta( iVentaService.findById(idVenta) );
				
				
				List<DTOVentaPago> fs = new ArrayList<DTOVentaPago>();
				
				listaPagosRealizados.forEach( is->
				{
					DTOVentaPago sa = new DTOVentaPago();
					sa.setPago( is.getPagoVenta() );
					sa.setFechaPago( is.getFechaPago().toString() );
					fs.add(sa);
					
					pagosServer.setListaPagos(fs);
					
					
				});
				
				
				
				
			}

					
					
			
			return ResponseEntity.status(HttpStatus.OK).body( pagosServer	 );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}	
	}

}
