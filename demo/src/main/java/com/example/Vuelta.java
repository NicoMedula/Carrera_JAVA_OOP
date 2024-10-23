package com.example;
public class Vuelta {
    private Piloto piloto;
    private Equipo equipo;
    private Circuito circuito;
    private double d;
    int vuelta;
    

    public Vuelta(Piloto piloto, Equipo equipo,double duracion,Circuito circuito ) {
        
        setDuracion(duracion);
        setCircuito(circuito);
        setPiloto(piloto);
        setEquipo(equipo);
    }

    public Vuelta(Piloto piloto, Equipo equipo,double duracion,int vuelta){
        setDuracion(duracion);
        this.vuelta = vuelta;
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
