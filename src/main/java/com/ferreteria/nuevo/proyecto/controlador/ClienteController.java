package com.ferreteria.nuevo.proyecto.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Cliente;
import com.ferreteria.nuevo.proyecto.modelo.ClientePersona;
import com.ferreteria.nuevo.proyecto.modelo.Persona;
import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.servicio.BaseServiceImpl;
import com.ferreteria.nuevo.proyecto.servicio.ClienteServiceImpl;
import com.ferreteria.nuevo.proyecto.servicio.IPersonaService;
import com.ferreteria.nuevo.proyecto.servicio.IServiceCliente;

@RestController
@RequestMapping(path = "/ferreteria/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>
{
	
	@Autowired 
	private IServiceCliente iServiceCliente;
	
	@Autowired
	private IPersonaService iPersonaService;
	
	@GetMapping(path = "/buscarclientes")
	public ResponseEntity<?> guardarCliente() {
		try {
			List<ClientePersona> listaClienteaPersona = new ArrayList<ClientePersona>();
			List<Cliente> listaClientes = iServiceCliente.buscarClientesService();
			
			listaClientes.forEach( item -> 
			{
			
					ClientePersona clientePersona = new ClientePersona();
					Persona p = new Persona();
					
					clientePersona.setIdCliente( item.getId() );
					clientePersona.setIdPersona( item.getPersona().getId() );
					clientePersona.setNombrePersona( item.getPersona().getNombrePersona() );
					
					listaClienteaPersona.add(clientePersona);
			});
			
			
			
			return ResponseEntity.status(HttpStatus.OK).body(listaClienteaPersona);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	@GetMapping(path = "/buscarcli")
	public ResponseEntity<?> buscarclientes() {
		try {
			List<ClientePersona> listaClienteaPersona = new ArrayList<ClientePersona>();
			List<Cliente> listaClientes = iServiceCliente.buscarClientesService();
		
			
			
			
			return ResponseEntity.status(HttpStatus.OK).body( iServiceCliente.findAll() );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	@PostMapping(path = "/savecliente")
	public ResponseEntity<?> saveCli( @RequestBody Cliente cliente) {
		try {
			Cliente cli = new Cliente();
			if( cliente != null)
			{
				Persona persona = iPersonaService.save( cliente.getPersona() );
				cli.setPersona(persona);
			}
					
			return ResponseEntity.status(HttpStatus.OK).body(iServiceCliente.save( cli ));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	@GetMapping(path = "/ObtenerUnCliente/{nombreCliente}")
	public ResponseEntity<?> obtenerUnCliente( @PathVariable("nombreCliente") String nombreCliente ) {

		try {	
			return ResponseEntity.status(HttpStatus.OK).body(iServiceCliente.findClienteByNombreService( nombreCliente ));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	@PutMapping(path = "/updateClient/{idCliente}")
	public ResponseEntity<?> obtenerUnCliente( @PathVariable("idCliente") int idCliente, @RequestBody Cliente cliente ) {

		try {	
			
			return ResponseEntity.status(HttpStatus.OK).body( iServiceCliente.updateCliente(idCliente, cliente) );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}

}
