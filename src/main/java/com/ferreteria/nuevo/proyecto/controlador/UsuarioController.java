package com.ferreteria.nuevo.proyecto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Usuario;
import com.ferreteria.nuevo.proyecto.servicio.IUsuarioService;
import com.ferreteria.nuevo.proyecto.servicio.UsuarioServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>
{
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@GetMapping("getusr")
	public ResponseEntity<?> getAllUsr() {
		try {
			
			return  ResponseEntity.status(HttpStatus.OK).body(iUsuarioService .findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
	@PostMapping("saveUser")
	public ResponseEntity<?> saveUser( @RequestBody Usuario usuario) 
	{
		try {
			System.err.println(usuario);
			return  ResponseEntity.status(HttpStatus.OK).body(iUsuarioService .save(usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}

}
