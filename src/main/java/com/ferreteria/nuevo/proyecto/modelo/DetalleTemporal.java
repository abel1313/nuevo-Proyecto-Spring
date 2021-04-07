package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "detalletemporal")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DetalleTemporal extends Base
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double precio;
	private double cantidad;
	private double subtotal;
	

	
	
	

}
