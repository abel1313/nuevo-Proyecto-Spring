package com.ferreteria.nuevo.proyecto.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ferreteria.nuevo.proyecto.modelo.Venta;

@Repository
public interface IVentaRepository extends BaseRepository<Venta, Integer>
{
	
//	@Query(value = "INSERT INTO ventas (fecha_venta, total_venta, cliente_id, usuario_id) VALUES (:fecha, :total, :cliente, :usuario)" ,nativeQuery = true)
//	 Venta addVentaIRepository(@Param("fecha") Date fecha, @Param("total") double total, @Param("cliente") int cliente, @Param("usuario") int usuario);

	@Query(value = "SELECT id, fecha_venta, total_venta, cliente_id, usuario_id  FROM ventas v WHERE v.fecha_Venta BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
	public List<Venta> findByFechaInicioAndFechaFin( @Param("fechaInicio") String fechaInicio,  @Param("fechaFin") String fechaFin );
	
	@Query(value = "SELECT v.id, v.fecha_venta, v.total_venta, v.cliente_id, v.usuario_id  FROM ventas v INNER JOIN clientes c ON v.cliente_id = c.id  WHERE v.fecha_Venta BETWEEN :fechaInicio AND :fechaFin AND c.id = :idcliente ", nativeQuery = true)
	public List<Venta> findByFechaInicioAndFechaFinCliente( @Param("fechaInicio") String fechaInicio,  @Param("fechaFin") String fechaFin, @Param("idcliente") int idcliente  );
}
