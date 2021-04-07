package com.ferreteria.nuevo.proyecto.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "pagosventa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PagosVenta extends Base
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column( name = "pago" )
	private double pagoVenta;
	
	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "fecha_pago" )
	private Date fechaPago;
	
	@ManyToOne( optional = false,fetch = FetchType.EAGER)  //  fetch = FetchType.EAGER es para ManyToOne y OneToOne y //  fetch = FetchType.LAZY es para OnetoMany y ManyToMany
	@JoinColumn( name = "venta_id", nullable = false, updatable = false )
	private Venta venta;
	

}
