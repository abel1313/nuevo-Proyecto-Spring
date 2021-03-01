package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.modelo.Proveedor;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IProductoRepository;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Integer> 
implements IProductoService
{
	@Autowired
	private IProductoRepository iProductoRepository;

	public ProductoServiceImpl(BaseRepository<Producto, Integer> baseRepository) {
		super(baseRepository);
		
	}

	@Override
	public Producto addProducto(Producto producto) throws Exception {
		
		try {
			return iProductoRepository.save(producto);
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean codigoBarra(String codigo) throws Exception {
		try {
			System.err.println("Cod Producto Service iMPLEMENT "+ iProductoRepository.existCodigoBarra(codigo));
			return ( iProductoRepository.existCodigoBarra(codigo) != null )  ? true: false;
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Producto> buscarByCodigoOrNombreService(String codigo) throws Exception {
		
		
		try {
			
			return iProductoRepository.buscarByCodigoOrNombreRepository(codigo, codigo);
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
		
	}

	


}
