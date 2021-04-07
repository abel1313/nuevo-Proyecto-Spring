package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "direcciones")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Direccion extends Base
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "municipio_Direccion" )
	private String municipioDireccion;
	
	@Column( name = "caracteristicas_Direccion" )
	private String caracteristicasDireccion;
	
	@Column( name = "descripccion_Direccion" )
	private String descripccionDireccion;
	

	

}
