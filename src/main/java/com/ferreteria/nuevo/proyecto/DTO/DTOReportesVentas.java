package com.ferreteria.nuevo.proyecto.DTO;

import com.ferreteria.nuevo.proyecto.modelo.Cliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DTOReportesVentas 
{
	
	private double totalVenta;
	private String fechaVenta;
	private String nombreCliente; 

}
