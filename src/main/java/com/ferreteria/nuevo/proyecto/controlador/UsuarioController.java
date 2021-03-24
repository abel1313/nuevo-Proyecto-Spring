package com.ferreteria.nuevo.proyecto.controlador;

import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.ferreteria.nuevo.proyecto.DTO.DTOPermisosUsuario;
import com.ferreteria.nuevo.proyecto.crypto.AES256TextEncryptor;
import com.ferreteria.nuevo.proyecto.modelo.Menu;
import com.ferreteria.nuevo.proyecto.modelo.Permiso;
import com.ferreteria.nuevo.proyecto.modelo.Usuario;
import com.ferreteria.nuevo.proyecto.servicio.IPermisoService;
import com.ferreteria.nuevo.proyecto.servicio.IUsuarioService;
import com.ferreteria.nuevo.proyecto.servicio.UsuarioServiceImpl;



@RestController
@RequestMapping(path = "/ferreteria/usuarios")
public class UsuarioController extends BaseControllerImpl<Usuario, UsuarioServiceImpl>
{
	
	@Autowired
	private IUsuarioService iUsuarioService;
	
	@Autowired
	private IPermisoService iPermisoService;
	

	
	@GetMapping("getusr")
	public ResponseEntity<?> getAllUsr() {
		try {
			
			return  ResponseEntity.status(HttpStatus.OK).body(iUsuarioService .findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
	
	@RequestMapping(value = "saveUser" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> saveUser( @RequestBody Usuario u) 
	{
		try {
			System.err.println(u);
			return  ResponseEntity.status(HttpStatus.OK).body( null ); // iUsuarioService .addUsuarioService(u)
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
	@RequestMapping(value = "accesousuario" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> accesousuario( @RequestBody Usuario usr) 
	{
		try {
		 		
			AES256TextEncryptor td= new AES256TextEncryptor();

		    //    String target = usr.getContra_Usuario() ;
		        String encrypted=td.encrypt( usr.getContra_Usuario() );
		    //    String decrypted=td.decrypt(encrypted);

			
			 boolean usuarioexiste = false;
			
			Usuario usuarioencontrado = iUsuarioService.findByUsuarioAndContraService(usr.getNombre_Usuario(), encrypted );
			DTOPermisosUsuario dtoPermisosUsuario = new DTOPermisosUsuario();
			if( usuarioencontrado != null )
			{
				
	
//				List<Permiso> listaPermisos = iPermisoService.findAll();
//			//	System.err.println( usuarioencontrado + " usu no" );
//				List<Integer> listPermisos = listaPermisos.stream()    
//		                .filter( item -> item.getUsuario().getId() == usuarioencontrado.getId() )
//		                .map( item-> item.getMenu().getId() )
//		                .collect(Collectors.toList());
				
				List<Integer> listPermisos = iPermisoService.listPermisos( usuarioencontrado.getId() );
				usuarioexiste = usuarioencontrado.getId() != 0 ? true: false;
						     
			     
			     Usuario usAcc = new Usuario();
			     usAcc.setNombre_Usuario( usuarioencontrado.getNombre_Usuario() );
			     usAcc.setId(usuarioencontrado.getId() );
			     dtoPermisosUsuario.setUsuario( usAcc  );
			     dtoPermisosUsuario.setListaPermiso(listPermisos);
			}
			
			// seleccione los productos del Ipermisos here el usuario = al encontrado
   
		     
			return  ResponseEntity.status(HttpStatus.OK).body( dtoPermisosUsuario   ); // iUsuarioService .addUsuarioService(u)
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'errorx': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
	
	@GetMapping("existsusuario/{nombreUsuario}")
	public ResponseEntity<?> existsUsuario( @PathVariable("nombreUsuario") String nombreUsuario ) {
		try {
			
			return  ResponseEntity.status(HttpStatus.OK).body(iUsuarioService .existsUsuarioService(nombreUsuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}

	@RequestMapping(value = "guardarusuario" ,method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> guardarUsuario( @RequestBody Usuario us) 
	{
		try {
		 
			AES256TextEncryptor td= new AES256TextEncryptor();

		  //      String target = us.getContra_Usuario() ;
		        String encrypted=td.encrypt( us.getContra_Usuario() );
		  //      String decrypted=td.decrypt(encrypted);



			us.setContra_Usuario(encrypted);
			
		//	System.err.println(us);
		     
			return ResponseEntity.status(HttpStatus.OK).body( iUsuarioService .addUsuarioService(us) ); // 
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'errorx': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}
}
