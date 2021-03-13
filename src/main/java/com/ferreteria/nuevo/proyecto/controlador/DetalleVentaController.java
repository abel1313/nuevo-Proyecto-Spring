package com.ferreteria.nuevo.proyecto.controlador;

import java.util.List;
import java.util.stream.Collectors;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.Cliente;
import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;
import com.ferreteria.nuevo.proyecto.modelo.Usuario;
import com.ferreteria.nuevo.proyecto.modelo.Venta;
import com.ferreteria.nuevo.proyecto.servicio.DetalleVentaServiceImpl;
import com.ferreteria.nuevo.proyecto.servicio.IDetalleVentaService;
import com.ferreteria.nuevo.proyecto.servicio.IVentaService;

@RestController
@RequestMapping(path = "/ferreteria/Detalle")
public class DetalleVentaController extends BaseControllerImpl<DetalleVenta, DetalleVentaServiceImpl> 
{

	@Autowired
	private IDetalleVentaService iDetalleVentaService;
	
	@Autowired
	private IVentaService iVentaService;
	
	@PostMapping("saveDetalle")
	public ResponseEntity<?> save(@RequestBody List<DetalleVenta> detalle) throws Exception 
	{

		try {
	List<DetalleVenta> det = 
			detalle
			.stream().
			filter
			(item-> item.getProducto().getId() != 0)
			.collect(Collectors.toList());
	
	double totalVenta = detalle.stream()
	.filter( item-> item.getProducto().getId() != 0 )
	.mapToDouble(item -> item.getSubtotalDetalleVenta() * item.getCantidadDetalleVenta() )
	.sum();
	
	Timestamp date = new Timestamp(new java.util.Date().getTime());
	
		Venta v = new Venta();
		Cliente c = det.get(0).getVenta().getCliente();
		Usuario u = new Usuario(); // det.get(0).getVenta().getUsuario();
	
		System.err.println(c.getId());
		
				v.setTotalVenta(totalVenta);
				v.setFechaVenta(date);
				
				v.setCliente(c);
				
				u.setId(2);
				v.setUsuario(u);
	
			
				Venta newVenta = iVentaService.addVenta(v);
	
					det.forEach( (item) -> 
					{
						DetalleVenta dt = item;
						dt.setVenta(newVenta);
						
						DetalleVenta dye = iDetalleVentaService.addDetalle(dt);
	
					});
	
	
	
System.err.println(totalVenta);
//System.err.println(det.size());



//	    List<Integer> list = new ArrayList<Integer>();
//	    
//        for(int i = 1; i< 10; i++){
//            list.add(i);
//        }
//
//        Stream<Integer> stream = list.stream();
//        List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0)
//                                               .collect(Collectors.toList());
//        System.out.print(evenNumbersList);
        
		

		
		//System.out.println( entity + " entity venta " + " detalle "  );
		
//		try {
//			Venta resVenta = (Venta) IVentaService.addVenta(venta);
//			System.err.println(resVenta);
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		


	
			return ResponseEntity.status(HttpStatus.OK).body( newVenta );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde "+e.getMessage()+" '}");
		}
	}
	
	
}
