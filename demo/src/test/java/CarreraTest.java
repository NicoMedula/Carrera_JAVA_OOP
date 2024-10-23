import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.example.Carrera;
import com.example.Circuito;
import com.example.Equipo;
import com.example.Ingeniero;
import com.example.Mecanico;
import com.example.Piloto;
import com.example.Vuelta;

public class CarreraTest {
    
   @Test
    void fecha_de_la_carrera_Test() {

    Carrera carrera = new Carrera(2022, 10, 2);

    LocalDate expectedDate = LocalDate.of(2022, 10, 2); 

    assertEquals(expectedDate, carrera.getFecha());
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

    @Test
    void registrar_vuelta_del_piloto_en_circuito() {
        Carrera carrera = new Carrera(2024,12,05);
        Piloto piloto = new Piloto("Franco Colapinto", "Argentina");
        Circuito circuito = new Circuito("Austin", 1234, 56); // nombre, longitud, cantidad de vueltas
        Equipo equipo = new Equipo("Williams");

        Vuelta vuelta1 = new Vuelta(piloto, equipo, circuito, 90.5); // 90.5 segundos en la vuelta
        Vuelta vuelta2 = new Vuelta(piloto, equipo, circuito, 88.1); // 90.5 segundos en la vuelta
        Vuelta vuelta3 = new Vuelta(piloto, equipo, circuito, 91.3); // 90.5 segundos en la vuelta
        // Verificar que la vuelta se haya registrado correctamente

        carrera.agregarVuelta(vuelta3);
        carrera.agregarVuelta(vuelta2);
        carrera.agregarVuelta(vuelta1);

        carrera.agregarPiloto(piloto);
        
        assertEquals(3, carrera.getVueltas().size());

        assertEquals(90.5, vuelta1.getDuracion(), 0);
        assertEquals(88.1, vuelta2.getDuracion(), 0);
        assertEquals(91.3, vuelta3.getDuracion(), 0);

        assertEquals("Franco Colapinto", vuelta1.getPiloto().getNombre());
        assertEquals("Argentina", vuelta1.getPiloto().getNacionalidad());
        assertEquals("Williams", vuelta1.getEquipo().getNombre());
        assertEquals(1234, circuito.getLongitud());
        assertEquals(56, circuito.getCantidadVueltas());
        assertEquals("Austin", circuito.getNombre());

        assertEquals(vuelta3, carrera.getVueltas().get(0));
        assertEquals(1, carrera.getParticipantes().size());
        
    }

    @Test
    void parcial_prueba_YTest(){
        Circuito circuito = new Circuito("UCP");
       
        Carrera carrera = new Carrera(circuito);

        // Crear 10 pilotos usando un bucle for
        for (int i = 1; i <= 10; i++) {
            Piloto piloto = new Piloto("Piloto " + i,"Argentino");
            Equipo equipo = new Equipo("Equipo " + i);
            
            // Insertar 56 vueltas para cada piloto
            for (int j = 1; j <= 56; j++) {
                double tiempo = i * j * 1000;
		    int numeroVuelta = j;
                Vuelta vuelta = new Vuelta(piloto, equipo, tiempo, numeroVuelta);
                carrera.setNumVuelta(numeroVuelta);
            }
            
            carrera.agregarPiloto(piloto);
        }







    }
}

