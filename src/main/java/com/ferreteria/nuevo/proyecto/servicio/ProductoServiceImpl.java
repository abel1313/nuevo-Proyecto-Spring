package com.ferreteria.nuevo.proyecto.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ferreteria.nuevo.proyecto.modelo.Producto;
import com.ferreteria.nuevo.proyecto.modelo.Proveedores;
import com.ferreteria.nuevo.proyecto.repository.BaseRepository;
import com.ferreteria.nuevo.proyecto.repository.IProductoRepository;

import com.ferreteria.nuevo.proyecto.repository.IProveedoresRepository;

@Service
public class ProductoServiceImpl extends BaseServiceImpl<Producto, Integer> 
implements IProductoService
{
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IProveedoresRepository iProveedorRepository;

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

	@Override
	public boolean existsCodigoBarraEditar(String codigo, int idProducto) throws Exception {
		try {
			
			return ( iProductoRepository.existCodigoBarraEditar( codigo, idProducto ) != 0 )  ? true: false;
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Producto updateProducto(Producto producto) throws Exception {
		try {
			
			Optional<Proveedores> findProveedor = iProveedorRepository.findById( producto.getProveedor().getId() );
			
			Proveedores pro = findProveedor.get();
			producto.setProveedor(pro);
			
			Optional<Producto> findProducto = iProductoRepository.findById( producto.getId() );
			Producto prod = findProducto.get();
			
			prod = iProductoRepository.save(producto);
			
			return prod;
			
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}

	


}
