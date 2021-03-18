package com.ferreteria.nuevo.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Permiso;
import com.ferreteria.nuevo.proyecto.modelo.VentasPagadas;
import com.ferreteria.nuevo.proyecto.servicio.IPermisoService;
import com.ferreteria.nuevo.proyecto.servicio.PermisoServiceImpl;

@RestController
@RequestMapping(path = "/ferreteria/permisos")
public class PermisoController extends BaseControllerImpl<Permiso, PermisoServiceImpl>
{
	
	@Autowired 
	private IPermisoService iPermisoService;
	
	@PostMapping("permisosAdd")
	public ResponseEntity<?> savePago(@RequestBody Permiso list) {
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body( iPermisoService.save(list));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde ' "+ e.getMessage()+" }");
		}
	}

}
