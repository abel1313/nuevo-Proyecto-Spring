package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "detalleventa")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class DetalleVenta  extends Base
{
	private static final long serialVersionUID = 1L;

	@Column( name = "subtotal_Detalle_Venta")
	private double subtotalDetalleVenta;
	
	@Column( name = "cantidad_Detalle_Venta")
	private double cantidadDetalleVenta;
	
	@Column( name = "precio_Detalle_Venta")
	private double precioDetalleVenta;
	
//	 @ManyToOne
//	 @JoinColumn( name = "venta_Id")
//	 private Venta venta;
	 
//	 @OneToOne
//	 @JoinColumn( name = "producto_Id")
//	 private Producto producto;

	   
	 
		@OneToOne 
	    @JoinColumn(name="venta_id",referencedColumnName="id")
	   	private Venta venta;
	   
		@OneToOne 
	    @JoinColumn(name="producto_id",referencedColumnName="id")
	   	private Producto producto;


	   



}
