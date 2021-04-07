package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Producto extends Base
{

	private static final long serialVersionUID = 1L;

			@Column( name = "nombre_Producto" )
			 private String nombreProducto;
		   	
		   	@Column( name = "codigo_Barras_Producto")
			 private String codigoBarrasProducto;
		   	
		   	@Column( name = "descripcion_Producto" )
			 private String descripcionProducto;
		   	
		   	@Column( name = "caracteristicas_Producto" )
			 private String caracteristicasProducto;
		   	
		   	@Column( name = "existencia_Producto" )
			 private double existenciaProducto;
		   	
		   	@Column( name = "precio_Producto")
		   	
			 private double precioProducto;
		   	
		   	
//		   	@ManyToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//		   	@JoinColumn(name = "proveedor_Id", nullable = false)
//		   	private Proveedor proveedor;
		   	
//		    @ManyToMany(mappedBy = "listaProductos")
//		    private List<Venta> listaVenta = new ArrayList<>();
		   	
//			@OneToMany( mappedBy = "producto" )
//			@JsonManagedReference
//			private List<DetalleVenta> listaDetalle;
		   	
		   	
		   	@ManyToOne( cascade = CascadeType.MERGE)
		   	@JoinColumn(name = "proveedor_id")
		   	private Proveedores proveedor;
		   	

		   	


}
