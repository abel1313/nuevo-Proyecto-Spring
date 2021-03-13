package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import com.ferreteria.nuevo.proyecto.modelo.Cliente;

public interface IServiceCliente extends IBaseService<Cliente, Integer>
{
	public List<Cliente> buscarClientesService();
	
	public List<Cliente> findClienteByNombreService( String nombrePersona) throws Exception;
	
	public Cliente updateCliente(Integer id, Cliente cli) throws Exception;
	
}
