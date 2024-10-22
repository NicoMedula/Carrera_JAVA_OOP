package com.example;
import java.util.ArrayList;
import java.time.LocalDate;

public class Circuito implements ISponsoreable {
    private String nombre;
    private double longitud;
    private int cantidadVueltas;
    private ArrayList<SponsorContrato> sponsors = new ArrayList<SponsorContrato>();

    

    public Circuito(String nombre, double longitud, int cantidadVueltas) {
        setNombre(nombre);
        setLongitud(longitud);
        setCantidadVueltas(cantidadVueltas);
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
    


}
