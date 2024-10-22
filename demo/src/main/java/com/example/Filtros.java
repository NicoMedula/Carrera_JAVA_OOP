package com.example;
import java.util.ArrayList;

public class Filtros {

    //¿Cuántos pilotos tienen una nacionalidad específica?
    public long contarPilotosPorNacionalidad(ArrayList<Piloto> pilotos, String nacionalidad) {
        return pilotos.stream()
                      .filter(p -> p.getNacionalidad().equals(nacionalidad))
                      .count();
    }

    //¿Cuántas vueltas fueron registradas en un circuito específico?
    public long contarVueltasPorCircuito(ArrayList<Vuelta> vueltas, String nombreCircuito) {
        return vueltas.stream()
                      .filter(v -> v.getCircuito().getNombre().equals(nombreCircuito))
                      .count();
    }

    //¿Cuántos pilotos de un equipo específico participaron en una carrera?
    public long contarPilotosPorEquipo(ArrayList<Vuelta> vueltas, String nombreEquipo) {
        return vueltas.stream()
                      .filter(v -> v.getEquipo().getNombre().equals(nombreEquipo))
                      .map(Vuelta::getPiloto)
                      .distinct()  // Evita duplicados
                      .count();
    }

    //¿Cuántas vueltas fueron más rápidas que un tiempo específico?
    public long contarVueltasMasRapidas(ArrayList<Vuelta> vueltas, double tiempoLimite) {
        return vueltas.stream()
                      .filter(v -> v.getDuracion() < tiempoLimite)
                      .count();
    }
    
    //¿Cuántos circuitos tienen una longitud mayor a un valor determinado?
    public long contarCircuitosPorLongitud(ArrayList<Circuito> circuitos, double longitudMinima) {
        return circuitos.stream()
                        .filter(c -> c.getLongitud() > longitudMinima)
                        .count();
    }
    
    

    
    
    
}
