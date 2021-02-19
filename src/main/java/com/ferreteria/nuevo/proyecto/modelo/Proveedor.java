package com.ferreteria.nuevo.proyecto.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "proveedores")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Proveedor extends Base
{
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column( name = "nombre_Proveedor")
	  @NotNull
	  private String nombreProveedor;
	  
	  @OneToMany( fetch = FetchType.EAGER)
	 @JoinColumn( name = "proveedor_id")
	 private List<Marca>listamarcas;
	  
	  

}
