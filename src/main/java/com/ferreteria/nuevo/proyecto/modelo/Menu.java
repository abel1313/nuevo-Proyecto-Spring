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
@Table(name = "menu")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Menu extends Base
{
	private static final long serialVersionUID = 1L;
	
	@Column( name = "nombre_menu" )
	private String nombreMenu;
	
	@Column( name = "estatus_menu" )
	private String estatusMenu;
	


}
