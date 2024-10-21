import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.Equipo;
import com.example.Sponsor;
import com.example.SponsorContrato;

public class EquipoTest {

    @Test
    void agregar_sponsor_Test(){
        Equipo equipo = new Equipo("Equipo1");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        equipo.agregar(sponsorContrato);

        assertEquals(1, equipo.getSponsors().size());
        assertEquals(sponsor1, equipo.getSponsors().get(0).getSponsor());
    }

    @Test
    void remover_sponsor_Test(){
        Equipo equipo = new Equipo("Equipo1");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        equipo.agregar(sponsorContrato);
        assertEquals(1, equipo.getSponsors().size());

        // se remueve el sponsor
        equipo.remover(sponsor1);

        // lista de sponsor debe estar vacía
        assertTrue(equipo.getSponsors().isEmpty());
        assertEquals(0, equipo.getSponsors().size());
    }

    @Test
    void no_se_puede_agregar_sponsor_duplicado_Test(){
        Equipo equipo = new Equipo("Equipo1");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        equipo.agregar(sponsorContrato1);
        assertEquals(1, equipo.getSponsors().size());

        // sponsor duplicado
        equipo.agregar(sponsorContrato2);

        // lista de sponsor debe tener solo un elemento
        assertEquals(1, equipo.getSponsors().size());
        assertEquals(sponsor1, equipo.getSponsors().get(0).getSponsor());
    }

    @Test
    void sponsor_en_ubicacion_Test(){
        Equipo equipo = new Equipo("Equipo1");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", LocalDate.now());
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor1, "Estadio", LocalDate.now());

        equipo.agregar(sponsorContrato1);
        equipo.agregar(sponsorContrato2);

        // sponsor en ubicación
        assertTrue(equipo.existeActivo(sponsor1, "Centro"));
        assertTrue(equipo.existeActivo(sponsor1, "Estadio"));
    }

    @Test
    public void existe_sponsor_activo_Test() {
        Equipo equipo = new Equipo("Equipo1");
        Sponsor sponsor1 = new Sponsor("Ferrari");
        SponsorContrato sponsorContrato = new SponsorContrato(sponsor1, "Centro", LocalDate.now());

        // Agregamos el sponsor
        equipo.agregar(sponsorContrato);

        // Verificamos que existeActivo devuelva true para el mismo sponsor y ubicación
        assertTrue(equipo.existeActivo(sponsor1, "Centro"));

        // false para otro sponsor o ubicación
        Sponsor sponsor2 = new Sponsor("Mercedes");
        assertFalse(equipo.existeActivo(sponsor2, "Centro"));
        assertFalse(equipo.existeActivo(sponsor1, "Sur"));
    }

    @Test
    public void sponsors_habilitados_Test() {
        Equipo equipo = new Equipo("Equipo1");

        Sponsor sponsor1 = new Sponsor("Ferrari");
        Sponsor sponsor2 = new Sponsor("Mercedes");

        SponsorContrato sponsorContrato1 = new SponsorContrato(sponsor1, "Centro", null);
        SponsorContrato sponsorContrato2 = new SponsorContrato(sponsor2, "Estadio", LocalDate.of(2022, 1, 1));
        SponsorContrato sponsorContrato3 = new SponsorContrato(sponsor2, "Sur", null);
        sponsorContrato2.setFechaHasta(LocalDate.of(2024,1,1));

        equipo.agregar(sponsorContrato1); // activo
        equipo.agregar(sponsorContrato2); // no activo
        equipo.agregar(sponsorContrato3); // activo

        assertEquals(2, equipo.sponsorsHabilitados().size());
        assertTrue(equipo.sponsorsHabilitados().contains(sponsorContrato1)); // Activo
        assertTrue(equipo.sponsorsHabilitados().contains(sponsorContrato3)); // Activo
        assertFalse(equipo.sponsorsHabilitados().contains(sponsorContrato2)); // No activo
    }

}
