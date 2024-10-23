package com.example;
import java.util.ArrayList;
import java.time.LocalDate;

/*Encapsulamiento: las propiedades como nombre, nacionalidad, ingenieroPrincipal, etc., 
son privadas, y los métodos get y set permiten acceder y modificar esos
 atributos de manera controlada 

Polimorfismo: Se ve en la implementación de la interfaz ISponsoreable por la clase Piloto
Diferentes implementaciones de los métodos remover() (sobrecarga)
 
 Abstraccion: Las clases Persona,Piloto,Mecanico,Ingeniero representan
 entidades del mundo real.

 Herencia: las clases Piloto,Mecanico,Ingeniero heredan de Persona (atributos).
 */

public class Circuito implements ISponsoreable,INombreParaLed {
    private String nombre;
    private double longitud;
    private int cantidadVueltas;
    private ArrayList<SponsorContrato> sponsors = new ArrayList<SponsorContrato>();
    Circuito circuito;

    

    public Circuito(String nombre, double longitud, int cantidadVueltas) {
        setNombre(nombre);
        setLongitud(longitud);
        setCantidadVueltas(cantidadVueltas);
    }
    public Circuito (String value){
        setNombre(value);
    }
    
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLongitud(){
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCantidadVueltas() {
        return cantidadVueltas;
    }
    
    private void setCantidadVueltas(int cantidadVueltas) {
        this.cantidadVueltas = cantidadVueltas;
    }

    // Metodo para validar si un sponsor ya esta en la misma ubicacion
    public boolean existeActivo(Sponsor sponsor, String ubicacion){
        for (SponsorContrato sc : sponsors) {
            if (sc.getSponsor().equals(sponsor) && sc.getUbicacion().equals(ubicacion) && sc.getFechaHasta() == null) {
                return true; 
            }
        }
        return false;
    }



    //Sponsors
    public ArrayList<SponsorContrato>getSponsors(){
        return sponsors;
    }

    @Override
    public void agregar(SponsorContrato sponsor) {
        if (!existeActivo(sponsor.getSponsor(), sponsor.getUbicacion())) {
            sponsors.add(sponsor);
        }
    }

    @Override
    public void agregar(Sponsor sponsor, String ubicacion, LocalDate fechaDesde) {
        SponsorContrato nuevoSponsorContrato = new SponsorContrato(sponsor, ubicacion, fechaDesde);
        agregar(nuevoSponsorContrato);
    }

    //Funcion lambda para remover un sponsor (tipo Sponsor)
    @Override
    public void remover(Sponsor sponsor) {
        sponsors.removeIf(sc -> sc.getSponsor().equals(sponsor));
    }

    @Override
    public void remover(String sponsor) {
        sponsors.removeIf(sc -> sc.getSponsor().getNombre().equals(sponsor));
    }

    @Override
    public void remover(Sponsor sponsor, String ubicacion) {
        sponsors.removeIf(sc -> sc.getSponsor().equals(sponsor) && sc.getUbicacion().equals(ubicacion));
    }

    public ArrayList<SponsorContrato> sponsorsHabilitados() {

        ArrayList<SponsorContrato> habilitados = new ArrayList<>();
        
        for (SponsorContrato sc : sponsors) {

            if (sc.getFechaHasta() == null) { //el sponsor esta activo
                habilitados.add(sc);
            }

        }

        return habilitados;
    }
    
    public String getNombreParaLed(){
        return "Circuito:"+" "+getNombre()+" "+ "(Longitud XXX mts.)";
     }


}
