package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KahootTest {

    @Test
    public void creoDosUsuariosYLosAlmacenoCorrectamente() {
        Kahoot kahoot = new Kahoot();
        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        assertEquals(2, kahoot.jugadores().size());
    }
    @Test
    public void buscaPuntajeAsignarDeCadaJugadorYSeLoAsigna() {
        Kahoot kahoot = new Kahoot();
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        ArrayList <Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList <Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Es correcto este test?", true);
        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");
        listaRespuestaJugador1.add(opcion1);
        listaRespuestaJugador2.add(opcion2);

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugador1);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugador2);
        kahoot.verificarRonda();

        assertEquals(1, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());
    }
}