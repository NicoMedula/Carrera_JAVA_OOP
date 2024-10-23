package com.example;

public class Ingeniero extends  Persona {
    
    public Ingeniero(String nombre, String nacionalidad) {
        super(nombre, nacionalidad);
    }
    
    @Override
    public String getNombreParaLed(){
        return getNombre();
     }
}
