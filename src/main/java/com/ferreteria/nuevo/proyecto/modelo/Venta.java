package com.ferreteria.nuevo.proyecto.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ventas")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Venta extends Base
{
	
	private static final long serialVersionUID = 1L;

	@Column( name = "total_Venta")
	private double totalVenta;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column( name = "fecha_Venta")
	private Date fechaVenta;
	
	
	@OneToMany(mappedBy = "venta")
	@JsonBackReference
	private List<Pedido> listPedidos;
	
	
//	 @OneToMany( cascade = CascadeType.PERSIST)
//	 @JoinColumn( name = "venta_Id")
//	 private List<DetalleVenta> detalle;

//	@ManyToMany
//		@JoinTable(name = "detalleventa",
//		    joinColumns = @JoinColumn(name = "venta_id"),
//		    inverseJoinColumns = @JoinColumn(name = "producto_id")
//		)

//	@OneToMany( mappedBy = "venta" )
//	@JsonManagedReference
//	private List<DetalleVenta> listaDetalle;
	
	 @OneToOne
	 @JoinColumn( name = "cliente_Id")
	 private Cliente cliente;
	 
	 @OneToOne
	 @JoinColumn( name = "usuario_Id")
	 private Usuario usuario;
	


}
