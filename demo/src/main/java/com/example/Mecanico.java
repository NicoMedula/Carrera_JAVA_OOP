package com.example;

public class Mecanico extends  Persona {
    
    public Mecanico(String nombre, String nacionalidad) {
        super(nombre, nacionalidad);
    }

    @Override
    public String getNombreParaLed(){
        return "Mecanico:"+ " "+getNombre();
     }
    
}
