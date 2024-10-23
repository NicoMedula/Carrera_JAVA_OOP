import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.Circuito;
import com.example.INombreParaLed;
import com.example.Mecanico;
import com.example.PantallaLED;
import com.example.Piloto;
import com.example.Sponsor;


//Pregunta 4 del parcial
public class NombreLEDTest {
    @Test
    void pantalla_led_piloto() {
        Piloto  piloto = new Piloto("Franco Colapinto","Argentina");
        var pantallaLED = new PantallaLED(piloto);
        assertEquals("Piloto: Franco Colapinto", pantallaLED.getTexto());
    }

    @Test
    void pantalla_led_mecanico() {
        Mecanico mecanico = new Mecanico("Mecanico 1","Argentino");
        var pantallaLED = new PantallaLED(mecanico);
        assertEquals("Mecanico: Mecanico 1", pantallaLED.getTexto());
    }

    @Test
    void pantalla_led_sponsor() {
        INombreParaLed sponsor = new Sponsor("Bizarrap");
        var pantallaLED = new PantallaLED(sponsor);
        assertEquals("Sponsor: Bizarrap", pantallaLED.getTexto());
    }


    @Test
    void pantalla_led_circuito() {
        Circuito  circuito = new Circuito("Austin",23,56);
        var pantallaLED = new PantallaLED(circuito);
        assertEquals("Circuito: Austin (Longitud XXX mts.)", pantallaLED.getTexto());
    }

}
