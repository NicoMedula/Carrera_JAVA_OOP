package com.example;
import java.util.ArrayList;
import java.time.LocalDate;

public class Carrera {
    private LocalDate fecha;

    private ArrayList<Piloto> participantes;
    private Circuito circuito;

    public Carrera(int anio,int mes, int dia) {
        setFecha(anio,mes,dia);
        participantes = new ArrayList<Piloto>();
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

}