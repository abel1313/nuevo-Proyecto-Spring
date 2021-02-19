/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ferreteria.nuevo.proyecto.exeptions;

/**
 *
 * @author abel_
 */
public class NotFoundExeption extends RuntimeException{

    public NotFoundExeption() {
    }
    public NotFoundExeption(String messaje) 
    {
        super(messaje);
    }
    
}
