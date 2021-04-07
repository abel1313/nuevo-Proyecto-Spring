package com.ferreteria.nuevo.proyecto.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categorias")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Categoria extends Base
{
	private static final long serialVersionUID = 1L;
	
	@Column( name = "nombre_Categoria" )
	private String nombreCategoria;
	
	@ManyToOne
	@JoinColumn( name = "estatus_Categoria_Id", referencedColumnName = "id" )
	@JsonBackReference
	private EstatusCategoria estatusCategoria;
	
	@OneToMany( mappedBy = "categoria")
	@JsonManagedReference
	private List<Tornilleria> tornilleria;
	


}
