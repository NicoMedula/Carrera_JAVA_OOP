import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.example.Circuito;
import com.example.Sponsor;
import com.example.SponsorContrato;

public class CircuitoTets {


    @Test
    void agregar_sponsor_Test(){
        Circuito circuito = new Circuito("Circuito1",10,5);
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        circuito.agregar(sponsorContrato);

        assertEquals(1,circuito.getSponsors().size());
        assertEquals(sponsor1, circuito.getSponsors().get(0).getSponsor());
    }

    @Test
    void remover_sponsor_Test(){
        Circuito circuito = new Circuito("Circuito1",10,5);
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        circuito.agregar(sponsorContrato);
        assertEquals(1, circuito.getSponsors().size());

        // se remueve el sponsor
        circuito.remover(sponsor1);

        // lista de sponsor debe estar vacia
        assertTrue(circuito.getSponsors().isEmpty());
        assertEquals(0, circuito.getSponsors().size());

    }

    @Test
    void no_se_puede_agregar_sponsor_duplicado_Test(){
        Circuito circuito = new Circuito("Circuito1",10,5);
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        circuito.agregar(sponsorContrato1);
        assertEquals(1, circuito.getSponsors().size());

        //sponsor duplicado
        circuito.agregar(sponsorContrato2);

        // lista de sponsor debe tener solo un elemento
        assertEquals(1, circuito.getSponsors().size());
        assertEquals(sponsor1, circuito.getSponsors().get(0).getSponsor());
    }

    @Test
    void sponsor_en_ubicacion_Test(){
        Circuito circuito = new Circuito("Circuito1",10,5);
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor1, "Estadio", LocalDate.now());

        circuito.agregar(sponsorContrato1);
        circuito.agregar(sponsorContrato2);

        // sponsor en ubicacion
        assertTrue(circuito.existeActivo(sponsor1, "Centro"));
        assertTrue(circuito.existeActivo(sponsor1, "Estadio"));
    }

    @Test
    public void existe_sponsor_activo_Test() {
        Circuito circuito = new Circuito("Circuito1",10,5);
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        // Agregamos el sponsor
        circuito.agregar(sponsorContrato);

        // Verificamos que existeActivo devuelva true para el mismo sponsor y ubicación
        assertTrue(circuito.existeActivo(sponsor1, "Centro"));

        //false para otro sponsor o ubicación
        Sponsor sponsor2 = new Sponsor("Mercedes");
        assertFalse(circuito.existeActivo(sponsor2, "Centro"));
        assertFalse(circuito.existeActivo(sponsor1, "Sur"));
    }

    @Test
    public void sponsors_habilitados_Test() {
        Circuito circuito = new Circuito("Circuito1",10,5);

        Sponsor sponsor1 = new Sponsor("Ferrari");
        Sponsor sponsor2 = new Sponsor("Mercedes");

        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", null);
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor2, "Estadio", LocalDate.of(2022, 1, 1));
        SponsorContrato sponsorContrato3 = new SponsorContrato(sponsor2, "Sur", null);
        sponsorContrato2.setFechaHasta(LocalDate.of(2024,1,1));

        circuito.agregar(sponsorContrato1);//activo
        circuito.agregar(sponsorContrato2);//no activo
        circuito.agregar(sponsorContrato3);//activo


        assertEquals(2, circuito.sponsorsHabilitados().size());
        assertTrue(circuito.sponsorsHabilitados().contains(sponsorContrato1)); // Activo
        assertTrue(circuito.sponsorsHabilitados().contains(sponsorContrato3)); // Activo
        assertFalse(circuito.sponsorsHabilitados().contains(sponsorContrato2)); // No activo

        
    }

}
