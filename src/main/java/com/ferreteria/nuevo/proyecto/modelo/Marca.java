package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "marcas")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Marca extends Base
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotNull( message = "Este campo no debe estar vacío" )
	@Min( 2 )
	@Column( name = "nombre_Marca")
	private String nombre_Marca;
	

}
