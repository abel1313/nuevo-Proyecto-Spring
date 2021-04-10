package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

	@NotNull( message = "Este campo no debe estar vacío" )
	@Size( min = 1, max = 50)
	@Column( name = "municipio_Direccion" )
	private String municipioDireccion;
	
	@NotNull( message = "Este campo no debe estar vacío" )
	@Size( min = 3, max = 50)
	@Column( name = "caracteristicas_Direccion" )
	private String caracteristicasDireccion;
	
	@NotNull( message = "Este campo no debe estar vacío" )
	@Size( min = 3, max = 50)
	@Column( name = "descripccion_Direccion" )
	private String descripccionDireccion;
	

	

}
