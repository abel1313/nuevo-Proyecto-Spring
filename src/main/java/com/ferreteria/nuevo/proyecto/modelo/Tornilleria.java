package com.ferreteria.nuevo.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tornilleria")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Tornilleria extends Base
{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn( name = "producto_Id", referencedColumnName = "id" )
	@JsonBackReference
	private Producto producto;

	@ManyToOne
	@JoinColumn( name = "categoria_Id", referencedColumnName = "id" )
	@JsonBackReference
	private Categoria categoria;

}
