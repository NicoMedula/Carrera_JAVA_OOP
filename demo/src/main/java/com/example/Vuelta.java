package com.example;
public class Vuelta {
    private Piloto piloto;
    private Equipo equipo;
    private Circuito circuito;
    private double d;

    public Vuelta(Piloto piloto, Equipo equipo, Circuito circuito, double d) {
        
        setDuracion(d);
        setCircuito(circuito);
        setPiloto(piloto);
        setEquipo(equipo);
    }

    public void setPiloto(Piloto piloto){
        this.piloto = piloto;
    }
    public Piloto getPiloto(){
        return piloto;
    }
    public void setEquipo(Equipo equipo){
        this.equipo = equipo;
    }
    public Equipo getEquipo(){
        return equipo;
    }
    public void setCircuito(Circuito circuito){
        this.circuito = circuito;
    }
    public Circuito getCircuito(){
        return circuito;
    }
    public void setDuracion(double d){
        this.d = d;
    }

    public double getDuracion() {
        return d;
    }

}
