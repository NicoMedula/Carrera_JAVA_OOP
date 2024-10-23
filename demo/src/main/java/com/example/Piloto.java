package com.example;
import java.time.LocalDate;
import java.util.ArrayList;

public class Piloto extends  Persona
                    implements ISponsoreable{

    private ArrayList<SponsorContrato> sponsors = new ArrayList<SponsorContrato>();
    
    public Piloto(String nombre, String nacionalidad) {
        super(nombre, nacionalidad);
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

    @Override
    public String getNombreParaLed(){
        return "Piloto:"+ " "+ getNombre();
     }



}
