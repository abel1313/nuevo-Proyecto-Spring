package com.ferreteria.nuevo.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ferreteria.nuevo.proyecto.modelo.Producto;


@Repository
public interface IProductoRepository extends BaseRepository<Producto, Integer> 
{
//	@Query( value = "INSERT INTO (nombreProducto, codigoBarrasProducto, descripcionProducto, caracteristicasProducto,"
//			+ "existenciaProducto, precioProducto, id) VALUE(?, ?, ? ,? ,?, ?, ?) ")
//	public Producto saveProveedor(Producto producto);
	
	
	@Query("SELECT p FROM Producto p where p.codigoBarrasProducto = :codigo")
	public Producto existCodigoBarra(@Param("codigo") String codigo);
	
	@Query("SELECT COUNT(p.codigoBarrasProducto) FROM Producto p WHERE p.codigoBarrasProducto = :codigo AND p.id <> :idProducto")
	public Integer existCodigoBarraEditar( @Param("codigo") String codigo, @Param("idProducto") int idProducto);
	
	@Query("SELECT p FROM Producto p where p.codigoBarrasProducto LIKE %:codigo% OR p.nombreProducto LIKE %:nombre%")
	public List<Producto> buscarByCodigoOrNombreRepository(@Param("codigo") String codigo, @Param("nombre") String nombre);
	

}
