package com.ferreteria.nuevo.proyecto.modelo;

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
@Table(name = "permisos")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Permiso extends Base
{

	private static final long serialVersionUID = 1L;
	

	@ManyToOne
	@JoinColumn( name = "usuario_id", referencedColumnName = "id")
	//@JsonManagedReference
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn( name = "menu_id", referencedColumnName = "id")
	//@JsonManagedReference
	private Menu menu;
	
	
	

}
