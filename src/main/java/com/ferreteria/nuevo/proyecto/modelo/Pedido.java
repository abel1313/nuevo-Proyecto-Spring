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
@Table(name = "pedidos")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Pedido extends Base
{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn( name = "ventas_id", referencedColumnName = "id" )
	
	private Venta venta;
	
	@ManyToOne
	@JoinColumn( name = "direccion_id", referencedColumnName = "id" )
	
	private Direccion direccion;
	
	
}
