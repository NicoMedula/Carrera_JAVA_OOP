import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.Carrera;
import com.example.Circuito;
import com.example.Equipo;
import com.example.Ingeniero;
import com.example.Mecanico;
import com.example.Piloto;

public class CarreraTest {
    
    @Test
    void testCarrera() {

        Carrera carrera = new Carrera(2022,10,2);
        assertEquals(2022, carrera.getFecha());
    }
    

    @Test 
    public void crear_una_carrera_completa_test(){

        Piloto piloto1 = new Piloto("Nicolas", "Argentina");
        Mecanico mecanico = new Mecanico("Uriel", "China");
        Ingeniero ingeniero = new Ingeniero("Maximo", "España");
        Carrera carrera = new Carrera(2021,2,13);
        Circuito carrera1 = new Circuito("Circuito 1", 100, 3);


        Equipo equipo = new Equipo("Ferrari");
        assertNotNull(equipo);

        equipo.agregarMecanico(mecanico);
        equipo.agregarPiloto(piloto1);
        equipo.setIngenieroPrincipal(ingeniero);

        

        assertEquals(piloto1, equipo.getPiloto().get(0));
        assertEquals(mecanico, equipo.getMecanicos().get(0));
        assertEquals(ingeniero, equipo.getIngenieroPrincipal());

        carrera.agregarPiloto(piloto1);
        carrera.setCircuito(carrera1);

        assertEquals(piloto1, carrera.getParticipantes().get(0));
        assertEquals(carrera1, carrera.getCircuito());
        assertEquals(1, carrera.getParticipantes().size());
        assertEquals(carrera1, carrera.getCircuito());
        assertEquals(1, carrera.getParticipantes().size());
       
    }
}

