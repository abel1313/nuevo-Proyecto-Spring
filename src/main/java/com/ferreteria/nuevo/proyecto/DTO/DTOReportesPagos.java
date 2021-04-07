package com.ferreteria.nuevo.proyecto.DTO;

import java.util.List;

import com.ferreteria.nuevo.proyecto.modelo.PagosVenta;
import com.ferreteria.nuevo.proyecto.modelo.Usuario;
import com.ferreteria.nuevo.proyecto.modelo.Venta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DTOReportesPagos 
{
	private Venta venta;
	private List<DTOVentaPago>listaPagos;
	

}
