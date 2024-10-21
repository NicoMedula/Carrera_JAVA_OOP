package com.example;

import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
    
    private ArrayList<Mecanico> mecanicos = new ArrayList<Mecanico>();
    private ArrayList<Piloto> pilotos  = new ArrayList<Piloto>();
    private Ingeniero  ingenieroPrincipal;
    private String nombre;
    private ArrayList<SponsorContrato> sponsors = new ArrayList<SponsorContrato>();

    public Equipo(String nombre) {
        setNombre(nombre);
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setIngenieroPrincipal(Ingeniero ingenieroPrincipal){
        this.ingenieroPrincipal = ingenieroPrincipal;
    }

    public Ingeniero getIngenieroPrincipal(){
        return ingenieroPrincipal;
    }

    public void agregarPiloto(Piloto piloto){
        pilotos.add(piloto);
    }

    public ArrayList<Piloto> getPiloto(){
        return pilotos;
    }

    public void agregarMecanico(Mecanico mecanico){
        mecanicos.add(mecanico);
    }

    public ArrayList<Mecanico> getMecanicos(){
        return mecanicos;
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

    public void agregar(SponsorContrato sponsor) {
        if (!existeActivo(sponsor.getSponsor(), sponsor.getUbicacion())) {
            sponsors.add(sponsor);
        }
    }
    
    public void agregar(Sponsor sponsor, String ubicacion, LocalDate fechaDesde) {
        SponsorContrato nuevoSponsorContrato = new SponsorContrato(sponsor, ubicacion, fechaDesde);
        agregar(nuevoSponsorContrato);
    }

    //Funcion lambda para remover un sponsor (tipo Sponsor)
    
    public void remover(Sponsor sponsor) {
        sponsors.removeIf(sc -> sc.getSponsor().equals(sponsor));
    }

    public void remover(String sponsor) {
        sponsors.removeIf(sc -> sc.getSponsor().getNombre().equals(sponsor));
    }

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
