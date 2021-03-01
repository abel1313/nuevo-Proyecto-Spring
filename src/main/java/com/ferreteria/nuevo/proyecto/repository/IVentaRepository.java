package com.ferreteria.nuevo.proyecto.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.Venta;

@Repository
public interface IVentaRepository extends BaseRepository<Venta, Integer>
{
	
//	@Query(value = "INSERT INTO ventas (fecha_venta, total_venta, cliente_id, usuario_id) VALUES (:fecha, :total, :cliente, :usuario)" ,nativeQuery = true)
//	 Venta addVentaIRepository(@Param("fecha") Date fecha, @Param("total") double total, @Param("cliente") int cliente, @Param("usuario") int usuario);

}
