package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaPuntajeTest {
    @Test
    public void asignaPuntajePositivoAUnJugador(){
        SistemaPuntaje sistema = new SistemaPuntaje();
        Usuario jugador = new Usuario("Edgar");
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(1);
        sistema.cambiarPuntaje(jugador,puntaje);

        assertEquals(1, jugador.puntaje().valor());

    }

    @Test
    public void asignaPuntajeNegativoAUnJugador(){
        SistemaPuntaje sistema = new SistemaPuntaje();
        Usuario jugador = new Usuario("Edgar");
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(-1);
        sistema.cambiarPuntaje(jugador,puntaje);

        assertEquals(-1, jugador.puntaje().valor());

    }
}
