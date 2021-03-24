package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.ferreteria.nuevo.proyecto.modelo.Permiso;

public interface IPermisoService extends IBaseService<Permiso, Integer>
{
	
	public List<Integer> listPermisos( @PathVariable int indUsuario )throws Exception;

}
