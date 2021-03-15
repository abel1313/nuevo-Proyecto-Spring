package com.ferreteria.nuevo.proyecto.servicio;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ferreteria.nuevo.proyecto.modelo.Usuario;

public interface IUsuarioService extends IBaseService<Usuario, Integer>
{
 public Usuario addUsuarioService(@RequestBody Usuario us)throws Exception;
 public Usuario findByUsuarioAndContraService(@PathParam("usuario") String usuario, @PathParam("contra") String contra )throws Exception;
 public Page<Usuario> findAll(Pageable pageable) throws Exception;
 
 public Boolean existsUsuarioService( @PathParam("usuario") String usuario ) throws Exception;
}
