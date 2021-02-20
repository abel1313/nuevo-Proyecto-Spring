package com.ferreteria.nuevo.proyecto.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.Producto;


@Repository
public interface IProductoRepository extends BaseRepository<Producto, Integer> 
{
//	@Query( value = "INSERT INTO (nombreProducto, codigoBarrasProducto, descripcionProducto, caracteristicasProducto,"
//			+ "existenciaProducto, precioProducto, id) VALUE(?, ?, ? ,? ,?, ?, ?) ")
//	public Producto saveProveedor(Producto producto);

}
