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
	
	
	
	@Query( value = "SELECT * FROM pagosventa pv \r\n"
			+ "	INNER JOIN ventas v ON v.id = pv.venta_id\r\n"
			+ "	INNER JOIN ventaspagadas vp ON vp.venta_id = v.id\r\n"
			+ "	WHERE pv.fecha_Pago =:buscarPago    ", nativeQuery = true )
	List<PagosVenta> findByClienteRepository( @Param("buscarPago") String buscarPago);
	
	
	
	
	
	@Query( value = "SELECT v.id, v.fecha_venta, v.total_venta, SUM(pv.pago) AS pago, pv.fecha_pago, vp.venta_id, \r\n"
			+ "pv.id, p.nombre_persona, p.materno_persona, p.paterno_persona\r\n"
			+ "FROM ventas v \r\n"
			+ "INNER JOIN pagosventa pv\r\n"
			+ "ON v.id = pv.venta_id \r\n"
			+ "\r\n"
			+ "INNER JOIN clientes c\r\n"
			+ "ON c.id= v.cliente_id\r\n"
			+ "INNER JOIN personas p\r\n"
			+ "ON p.id = c.persona_Id\r\n"
			+ "\r\n"
			+ "INNER JOIN ventaspagadas vp\r\n"
			+ "ON vp.venta_id = v.id\r\n"
			+ "\r\n"
			+ "INNER JOIN estatusventa et\r\n"
			+ "ON et.id = vp.estatusventa_id\r\n"
			+ "\r\n"
			+ "WHERE et.id = 2 \r\n"
			+ "GROUP BY v.id ORDER BY p.nombre_persona", nativeQuery = true )
	public List<PagosVenta> findByPagosClienteRepository();


}
