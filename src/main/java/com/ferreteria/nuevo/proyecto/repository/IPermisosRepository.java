package com.ferreteria.nuevo.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.Permiso;

@Repository
public interface IPermisosRepository extends BaseRepository<Permiso, Integer>
{

	@Query( value = "SELECT p.menu_Id FROM  permisos p WHERE p.usuario_Id = :idUsuario", nativeQuery = true )
	public List<Integer> listaPermisos( @Param("idUsuario") int idUsuario);
}
