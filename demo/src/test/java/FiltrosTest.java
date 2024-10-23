import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import com.example.Carrera;
import com.example.Circuito;
import com.example.Equipo;
import com.example.Filtros;
import com.example.Piloto;
import com.example.Vuelta;

public class FiltrosTest {

    @Test
    void filtro_contar_piloto_por_nacionalidad_Test(){
        Filtros filtro = new Filtros();

        Carrera carrera = new Carrera(2024, 2, 1);

        Piloto piloto1 = new Piloto("Franco Colapinto", "Argentina");
        Piloto piloto2 = new Piloto("Lewis Hamilton", "Argentina");
        Piloto piloto3 = new Piloto("Alonso", "España");

        carrera.agregarPiloto(piloto1);
        carrera.agregarPiloto(piloto2);
        carrera.agregarPiloto(piloto3);
        

        long cantidadArgentinos = filtro.contarPilotosPorNacionalidad(carrera.getParticipantes(), "Argentina");

        assertEquals(2, cantidadArgentinos);

    }

    @Test
    void flitro_contar_vueltas_por_circuito_Test(){

        Filtros filtro = new Filtros();

        Carrera carrera = new Carrera(2024, 10, 04);

        Circuito circuitoAustin = new Circuito("Austin", 13,50);
        Circuito circuitoMonaco = new Circuito("Monaco", 25,35);

        Piloto piloto1 = new Piloto("Nicolas", "Argentina");
        Equipo equipo = new Equipo("Ferrari");

        Vuelta vuelta1 = new Vuelta(piloto1, equipo, circuitoMonaco, 20.23);
        Vuelta vuelta2 = new Vuelta(piloto1, equipo, circuitoMonaco, 20.23);
        Vuelta vuelta3 = new Vuelta(piloto1, equipo, circuitoMonaco, 20.23);
        Vuelta vuelta4 = new Vuelta(piloto1, equipo, circuitoAustin, 20.23);

        carrera.agregarVuelta(vuelta4);
        carrera.agregarVuelta(vuelta1);
        carrera.agregarVuelta(vuelta3);
        carrera.agregarVuelta(vuelta2);

        long vueltasPorCircuito = filtro.contarVueltasPorCircuito(carrera.getVueltas(),"Monaco" );

        assertEquals(3, vueltasPorCircuito);


    }

    @Test
    void filtro_contar_pilotos_por_equipo_Test() {
        Filtros filtro = new Filtros();
        Carrera carrera = new Carrera(2024, 2, 1);
        
        Piloto piloto1 = new Piloto("Charles Leclerc", "Monaco");
        Piloto piloto2 = new Piloto("Carlos Sainz", "España");
        Piloto piloto3 = new Piloto("Lewis Hamilton", "Reino Unido");
        
        Equipo ferrari = new Equipo("Ferrari");
        Equipo mercedes = new Equipo("Mercedes");
        
        Circuito circuitoMonza = new Circuito("Monza", 20,30);
        
        Vuelta vuelta1 = new Vuelta(piloto1, ferrari, circuitoMonza, 80.5);
        Vuelta vuelta2 = new Vuelta(piloto2, ferrari, circuitoMonza, 81.2);
        Vuelta vuelta3 = new Vuelta(piloto3, mercedes, circuitoMonza, 80.8);
        Vuelta vuelta4 = new Vuelta(piloto1, ferrari, circuitoMonza, 79.9); // Vuelta adicional del piloto1
        
        carrera.agregarVuelta(vuelta1);
        carrera.agregarVuelta(vuelta2);
        carrera.agregarVuelta(vuelta3);
        carrera.agregarVuelta(vuelta4);
        
        long pilotosFerrari = filtro.contarPilotosPorEquipo(carrera.getVueltas(), "Ferrari");
        assertEquals(2, pilotosFerrari); // Debe contar a Leclerc y Sainz una sola vez
    }

    @Test
    void filtro_contar_vueltas_mas_rapidas_Test() {
        Filtros filtro = new Filtros();
        Carrera carrera = new Carrera(2024, 3, 15);
        
        Piloto piloto = new Piloto("Max Verstappen", "Paises Bajos");
        Equipo equipo = new Equipo("Red Bull");
        Circuito circuito = new Circuito("Silverstone", 18,56);
        
        Vuelta vuelta1 = new Vuelta(piloto, equipo, circuito, 82.5);
        Vuelta vuelta2 = new Vuelta(piloto, equipo, circuito, 80.3);
        Vuelta vuelta3 = new Vuelta(piloto, equipo, circuito, 81.7);
        Vuelta vuelta4 = new Vuelta(piloto, equipo, circuito, 79.9);
        
        carrera.agregarVuelta(vuelta1);
        carrera.agregarVuelta(vuelta2);
        carrera.agregarVuelta(vuelta3);
        carrera.agregarVuelta(vuelta4);
        
        long vueltasRapidas = filtro.contarVueltasMasRapidas(carrera.getVueltas(), 81.0);
        assertEquals(2, vueltasRapidas); // Debe contar las vueltas de 80.3 y 79.9
    }

    @Test
    void filtro_contar_circuitos_por_longitud_Test() {
        Filtros filtro = new Filtros();
        
        ArrayList<Circuito> circuitos = new ArrayList<>();
        
        Circuito circuito1 = new Circuito("Monaco", 3.337,34);
        Circuito circuito2 = new Circuito("Spa", 7.004,34);
        Circuito circuito3 = new Circuito("Monza", 5.793,34);
        Circuito circuito4 = new Circuito("Silverstone", 5.891,34);
        
        circuitos.add(circuito1);
        circuitos.add(circuito2);
        circuitos.add(circuito3);
        circuitos.add(circuito4);
        
        long circuitosLargos = filtro.contarCircuitosPorLongitud(circuitos, 5.8);
        assertEquals(2, circuitosLargos); // Debe contar Spa y Silverstone
    }





}
