
package com.ferreteria.nuevo.proyecto.config;

import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.ferreteria.nuevo.proyecto.exeptions.BadRequest;



@ControllerAdvice(annotations = RestController.class)
public class ConfigExeptions 
{
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundExeption(Exception e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<?> badRequestExeption(Exception e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
    
}
