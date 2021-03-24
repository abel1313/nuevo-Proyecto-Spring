package com.ferreteria.nuevo.proyecto.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Pedido;
import com.ferreteria.nuevo.proyecto.modelo.Permiso;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IPedidosRepository;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Integer> implements IPedidoService

{
@Autowired
	IPedidosRepository iPerIPedidosRepository;

	public PedidoServiceImpl(BaseRepository<Pedido, Integer> baseRepository) {
		super(baseRepository);
		// TODO Auto-generated constructor stub
	}

}
