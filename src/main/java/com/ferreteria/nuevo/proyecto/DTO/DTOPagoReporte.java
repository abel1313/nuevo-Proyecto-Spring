package com.ferreteria.nuevo.proyecto.DTO;

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
public class DTOPagoReporte 
{
	private int id;
	private String nombreCliente;
	private double totalVenta;
	private double pagoRealizado;
	private String fechaDeposito;
	private double adeudo;
	private double totalPagos;
	

}
