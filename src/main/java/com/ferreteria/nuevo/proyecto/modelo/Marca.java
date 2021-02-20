package com.ferreteria.nuevo.proyecto.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@Column( name = "nombre_Marca")
	private String nombre_Marca;
	

}
