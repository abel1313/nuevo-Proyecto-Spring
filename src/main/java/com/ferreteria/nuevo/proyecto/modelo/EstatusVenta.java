package com.ferreteria.nuevo.proyecto.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "estatusventa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EstatusVenta extends Base
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column( name = "nombre_estatus" )
	private String nombreEstatus;

}
