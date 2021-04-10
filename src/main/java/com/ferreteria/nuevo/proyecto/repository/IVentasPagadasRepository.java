package com.ferreteria.nuevo.proyecto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.VentasPagadas;

@Repository
public interface IVentasPagadasRepository extends BaseRepository<VentasPagadas, Integer>
{
	
	@Query( value = "SELECT * FROM ventaspagadas vp WHERE vp.venta_id = :idVenta ", nativeQuery = true )
	public VentasPagadas ventasPagadas( @Param("idVenta") int idVenta );
}
