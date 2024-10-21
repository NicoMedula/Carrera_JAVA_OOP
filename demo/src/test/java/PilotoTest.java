import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.Piloto;
import com.example.Sponsor;
import com.example.SponsorContrato;

public class PilotoTest {

    @Test
    void agregar_sponsor_Test(){
        Piloto piloto = new Piloto("Piloto1","Argentino");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        piloto.agregar(sponsorContrato);

        assertEquals(1, piloto.getSponsors().size());
        assertEquals(sponsor1, piloto.getSponsors().get(0).getSponsor());
    }

    @Test
    void remover_sponsor_Test(){
        Piloto piloto = new Piloto("Piloto1","Argentino");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        piloto.agregar(sponsorContrato);
        assertEquals(1, piloto.getSponsors().size());

        // se remueve el sponsor
        piloto.remover(sponsor1);

        // lista de sponsor debe estar vacía
        assertTrue(piloto.getSponsors().isEmpty());
        assertEquals(0, piloto.getSponsors().size());
    }

    @Test
    void no_se_puede_agregar_sponsor_duplicado_Test(){
        Piloto piloto = new Piloto("Piloto1","Argentino");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        piloto.agregar(sponsorContrato1);
        assertEquals(1, piloto.getSponsors().size());

        // sponsor duplicado
        piloto.agregar(sponsorContrato2);

        // lista de sponsor debe tener solo un elemento
        assertEquals(1, piloto.getSponsors().size());
        assertEquals(sponsor1, piloto.getSponsors().get(0).getSponsor());
    }

    @Test
    void sponsor_en_ubicacion_Test(){
        Piloto piloto = new Piloto("Piloto1","Argentino");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor1, "Estadio", LocalDate.now());

        piloto.agregar(sponsorContrato1);
        piloto.agregar(sponsorContrato2);

        // sponsor en ubicación
        assertTrue(piloto.existeActivo(sponsor1, "Centro"));
        assertTrue(piloto.existeActivo(sponsor1, "Estadio"));
    }

    @Test
    public void existe_sponsor_activo_Test() {
        Piloto piloto = new Piloto("Piloto1","Argentino");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        // Agregamos el sponsor
        piloto.agregar(sponsorContrato);

        // Verificamos que existeActivo devuelva true para el mismo sponsor y ubicación
        assertTrue(piloto.existeActivo(sponsor1, "Centro"));

        // false para otro sponsor o ubicación
        Sponsor sponsor2 = new Sponsor("Mercedes");
        assertFalse(piloto.existeActivo(sponsor2, "Centro"));
        assertFalse(piloto.existeActivo(sponsor1, "Sur"));
    }

    @Test
    public void sponsors_habilitados_Test() {
        Piloto piloto = new Piloto("Piloto1","Argentino");

        Sponsor sponsor1 = new Sponsor("Ferrari");
        Sponsor sponsor2 = new Sponsor("Mercedes");

        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", null);
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor2, "Estadio", LocalDate.of(2022, 1, 1));
        SponsorContrato sponsorContrato3 = new SponsorContrato(sponsor2, "Sur", null);
        sponsorContrato2.setFechaHasta(LocalDate.of(2024,1,1));

        piloto.agregar(sponsorContrato1); // activo
        piloto.agregar(sponsorContrato2); // no activo
        piloto.agregar(sponsorContrato3); // activo

        assertEquals(2, piloto.sponsorsHabilitados().size());
        assertTrue(piloto.sponsorsHabilitados().contains(sponsorContrato1)); // Activo
        assertTrue(piloto.sponsorsHabilitados().contains(sponsorContrato3)); // Activo
        assertFalse(piloto.sponsorsHabilitados().contains(sponsorContrato2)); // No activo
    }

}
