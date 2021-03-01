package com.ferreteria.nuevo.proyecto.controlador;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.modelo.DetalleVenta;
import com.ferreteria.nuevo.proyecto.modelo.Venta;
import com.ferreteria.nuevo.proyecto.servicio.IVentaService;
import com.ferreteria.nuevo.proyecto.servicio.VentaServiceImpl;


@RestController
@RequestMapping(path = "/ferreteria/ventas")
public class VentaController extends BaseControllerImpl<Venta, VentaServiceImpl>
{
	
	@Autowired
	private IVentaService IVentaService;
	
	@PostMapping("saveVenta")
	public ResponseEntity<?> save(@RequestBody Venta venta) 
	{



		List<DetalleVenta> det = venta.getDetalle().stream().filter(item-> item.getId() != 0).collect(Collectors.toList());
System.err.println(det);
System.err.println(det.size());



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
try {
	Venta ve = IVentaService.addVenta(venta);
	System.err.println(ve);
} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}

		try {
			return ResponseEntity.status(HttpStatus.OK).body("");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde'}");
		}
	}
	
	@GetMapping("saveVenta")
	public ResponseEntity<?> newadd() 
	{
		
		
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body("{'error': 'Buena por eso'}" );
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{'error': 'Por favor intente mas tarde'}");
		}
	}


}
