package com.example;
import java.util.ArrayList;
import java.time.LocalDate;

/*
 S (Single Responsibility) 
Las clases tienen responsabilidades bien definidas, 
pero Equipo tiene demasiadas responsabilidades (gestión de pilotos, mecánicos, sponsors)

O (Open/Closed) 
El diseño permite extender funcionalidad sin modificar código existente
Nuevos tipos de personas pueden heredar de Persona

L (Liskov Substitution) 
Las subclases (Piloto, Ingeniero) pueden sustituir a la clase base Persona

I (Interface Segregation)
La interfaz ISponsoreable podría dividirse en interfaces más pequeñas si hay clases que no necesitan implementar todos los métodos

D (Dependency Inversion) 
Hay algunas dependencias directas que podrían mejorarse usando interfaces

 */

public class Carrera {
    private LocalDate fecha;

    private ArrayList<Piloto> participantes;
    private Circuito circuito;
    private ArrayList<Vuelta> vueltas;
    int numeroVuelta = 0;

    public Carrera(int anio,int mes, int dia) {
        setFecha(anio,mes,dia);
        participantes = new ArrayList<Piloto>();
        vueltas = new ArrayList<Vuelta>();
    }
    public Carrera(Circuito circuito){
        this.circuito = circuito;
    }

    public void setNumVuelta(int vuelta){
        numeroVuelta = numeroVuelta +1;
    }


    public void setFecha(int anio,int mes, int dia){
        this.fecha = LocalDate.of(anio, mes, dia);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void agregarPiloto(Piloto piloto){
        participantes.add(piloto);
    }

    public ArrayList<Piloto> getParticipantes(){
        return participantes;
    }

    public void setCircuito(Circuito circuito){
        this.circuito = circuito;
    }
    public Circuito getCircuito(){
        return circuito;
    }

    public void agregarVuelta(Vuelta vuelta){
        vueltas.add(vuelta);
    }
    public ArrayList<Vuelta> getVueltas(){
        return vueltas;
    }

}