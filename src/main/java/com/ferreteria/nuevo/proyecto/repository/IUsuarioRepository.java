package com.ferreteria.nuevo.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.Usuario;

@Repository
public interface IUsuarioRepository extends BaseRepository<Usuario, Integer>
{
	@Query( value = "SELECT id, nombre_Usuario, contra_Usuario FROM usuarios WHERE nombre_Usuario = :usuario AND contra_Usuario = :contra ", nativeQuery = true )
	public Usuario findByNombre_UsuarioAndContra_Usuario(@Param("usuario") String usuario, @Param("contra") String contra);
	
	@Query( value = "SELECT COUNT(u.nombre_Usuario) FROM usuarios u WHERE nombre_Usuario = :usuario", nativeQuery = true )
	public Integer existUsuario( @Param("usuario") String usuario);
}
