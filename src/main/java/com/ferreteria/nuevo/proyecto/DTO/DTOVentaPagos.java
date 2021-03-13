package com.ferreteria.nuevo.proyecto.DTO;

import java.util.List;

import com.ferreteria.nuevo.proyecto.modelo.Cliente;
import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;
import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;
import com.ferreteria.nuevo.proyecto.modelo.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DTOVentaPagos 
{
	private int idVenta;
	
	private double totalPagosVenta;
	
	private double totalVenta;
	
	private double totalResta;
	
	private String fechaVenta;
	
	private Cliente cliente;
	
	private Usuario usuario;

	

}
