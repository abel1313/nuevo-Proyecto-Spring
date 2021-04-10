package com.ferreteria.nuevo.proyecto.modelo;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "estatuscategoria")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class EstatusCategoria extends Base
{
	private static final long serialVersionUID = 1L;
	
	@NotNull( message = "Este campo no debe estar vacío" )
	@Min( 2 )
	@Column( name = "nombre_Estatus_Categoria" )
	private String nombreEstatusCategoria;
	
	@OneToMany( mappedBy = "estatusCategoria")
	@JsonManagedReference
	private List<Categoria> categorias;

}
