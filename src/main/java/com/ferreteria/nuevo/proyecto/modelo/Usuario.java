package com.ferreteria.nuevo.proyecto.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Usuario extends Base
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "nombre_Usuario")
	private String nombreUsuario;
	
	@Column( name = "contra_Usuario")
	private String contraUsuario;
	
	

}
