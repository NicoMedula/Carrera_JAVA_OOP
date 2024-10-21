package com.example;
import java.util.ArrayList;
import java.time.LocalDate;

public interface ISponsoreable {
    ArrayList<SponsorContrato>getSponsors();
    void agregar(SponsorContrato sponsor);
    void agregar(Sponsor sponsor,String ubicacion,LocalDate fechaDesde);
    void remover(Sponsor sponsor);
    void remover(String sponsor);
    void remover(Sponsor sponsor, String ubicacion);
    ArrayList<SponsorContrato> sponsorsHabilitados();
}
