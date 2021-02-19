package com.ferreteria.nuevo.proyecto.controlador;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ferreteria.nuevo.proyecto.modelo.Base;



public interface IBaseController <E extends Base, ID extends Serializable> 
{
	public ResponseEntity<?> getaAll();
	public ResponseEntity<?> getOne(@PathVariable ID id);
	public ResponseEntity<?> save(@RequestBody E entity);
	public ResponseEntity<?> update(@PathVariable ID id ,@RequestBody E entity);
	public ResponseEntity<?> delete(@PathVariable ID id);

}
