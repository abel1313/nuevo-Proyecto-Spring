package com.ferreteria.nuevo.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.Cliente;

import net.bytebuddy.implementation.Implementation;

@Repository
public interface IClienteRepository extends BaseRepository<Cliente, Integer>
{

	//@Query( value = "SELECT * from cliente" )
	//public List<Cliente> buscarClientes();
	
	@Query( value = "SELECT c.id,\r\n"
			+ "  c.persona_Id,\r\n"
			+ "  p.nombre_Persona,\r\n"
			+ "  p.materno_Persona,\r\n"
			+ "  p.paterno_Persona,\r\n"
			+ "  p.telefono_persona\r\n"
			+ "  FROM clientes c\r\n"
			+ "  INNER JOIN personas p\r\n"
			+ "  on c.persona_Id = p.id\r\n"
			+ "  WHERE p.nombre_Persona LIKE %:nombrePersona%", nativeQuery = true)
	public List<Cliente> findByNombreClienteLike( @Param("nombrePersona") String nombrePersona );
}
