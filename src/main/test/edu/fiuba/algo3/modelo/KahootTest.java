package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

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
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Es correcto este test?", true);
        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");
        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).elegirRespuestaParaPrueba(pregunta,0);//elijo 0
        kahoot.jugadores().get(1).elegirRespuestaParaPrueba(pregunta,1);//elijo 1
        kahoot.verificarRonda();

        assertEquals(1, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());
    }
}
