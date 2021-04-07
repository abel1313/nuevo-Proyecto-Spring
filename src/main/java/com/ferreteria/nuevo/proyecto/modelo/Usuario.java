package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Usuario extends Base
{

	private static final long serialVersionUID = 1L;

	@Column( name = "nombre_Usuario")
	private String nombre_Usuario;
	
	@Column( name = "contra_Usuario")
	private String contra_Usuario;
	
//	@OneToMany( mappedBy = "usuario")
//	@JsonBackReference
//	private List<Permiso>listaPermiso;

}
