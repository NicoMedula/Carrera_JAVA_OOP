package com.example;

public class Sponsor {
    
    private String nombre;

    public Sponsor(String nombre) {
        setNombre(nombre);
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;  
    }

    
}
