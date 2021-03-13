package com.ferreteria.nuevo.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;
import com.ferreteria.nuevo.proyecto.modelo.Venta;

@Repository
public interface IPagosVentaRepository extends BaseRepository<PagosVenta, Integer>
{
	public List<PagosVenta> findByVentaId(int ventaId);
	
	@Query( value = "SELECT id, SUM(pago) AS pago, fecha_pago, venta_id FROM pagosventa vp GROUP BY venta_id", nativeQuery = true )
	public List<PagosVenta> listPagosVentas();
	
	@Query( value = "SELECT vp.id, SUM(vp.pago) AS pago, vp.fecha_pago, vp.venta_id \r\n"
			+ "FROM pagosventa vp\r\n"
			+ "INNER JOIN ventas v \r\n"
			+ "ON  v.id = vp.venta_id \r\n "
			+ "INNER JOIN clientes c \r\n"
			+ "ON v.cliente_id = c.id \r\n"
			+ "INNER JOIN personas p \r\n"
			+ "ON c.persona_Id = p.id  \r\n"
			+ "WHERE p.nombre_persona LIKE %:nombrePersona%", nativeQuery = true )
	public List<PagosVenta> findClienteByClientePersonaNombrePersonaLike(@Param("nombrePersona") String nombrePersona);
	


}
