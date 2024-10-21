package com.example;
import java.time.LocalDate;

public class SponsorContrato {
    private String ubicacion;
    private LocalDate fechaDesde;
    private LocalDate fechaHasta = null;
    private Sponsor sponsor;

    public SponsorContrato(Sponsor sponsor,String ubicacion, LocalDate fechaDesde) {
        setSponsor(sponsor);
        setUbicacion(ubicacion);
        setFechaDesde(fechaDesde);
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public LocalDate getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(LocalDate fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public LocalDate getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(LocalDate fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Sponsor getSponsor(){
        return sponsor;
    }

    public void setSponsor(Sponsor sponsor){
        this.sponsor = sponsor;
    }
}
