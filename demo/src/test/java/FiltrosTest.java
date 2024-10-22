import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.Carrera;
import com.example.Filtros;
import com.example.Piloto;

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

    void flitro_contar_vueltas_por_circuito_Test(){
        
    }

}
