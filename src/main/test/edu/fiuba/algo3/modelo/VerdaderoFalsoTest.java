package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void seCreaPreguntaVerdaderoFalsoIndicandoRespuestaCorrecta(){

        Opcion opcionCorrecta = new Opcion("Verdadero");
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial",true);


        assertEquals(opcionCorrecta.valor(), pregunta.opcionCorrecta().valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasYAsignaCorrectamentePuntajeALosJugadoresQueRespondieronCorrectamente(){
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugadorUno = new Usuario("Jorge");
        Usuario jugador2 = new Usuario("Ramiro");
        ArrayList<Opcion> listaRespuestaJugadorUno = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial",true);

        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        listaRespuestaJugadorUno.add(opcionUno);
        listaRespuestaJugador2.add(opcion2);
        jugadorUno.cargarRespuestas(listaRespuestaJugadorUno);
        jugador2.cargarRespuestas(listaRespuestaJugador2);
        Puntaje puntajeParcialJugadorUno = pregunta.calcularPuntajeParaRespuesta(jugadorUno.respuestas());
        Puntaje puntajeParcialJugador2 = pregunta.calcularPuntajeParaRespuesta(jugador2.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugadorUno,puntajeParcialJugadorUno);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);

        assertEquals(1, jugadorUno.puntaje().valor());
        assertEquals(0, jugador2.puntaje().valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasEnVerdaderoFalsoPenalidadYAsignaPuntajeCorrectamente(){

        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugadorUno = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        ArrayList<Opcion> listaRespuestaJugadorUno = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);

        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        listaRespuestaJugadorUno.add(opcionUno);
        listaRespuestaJugador2.add(opcion2);
        jugadorUno.cargarRespuestas(listaRespuestaJugadorUno);
        jugador2.cargarRespuestas(listaRespuestaJugador2);
        Puntaje puntajeParcialJugadorUno = pregunta.calcularPuntajeParaRespuesta(jugadorUno.respuestas());
        Puntaje puntajeParcialJugador2 = pregunta.calcularPuntajeParaRespuesta(jugador2.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugadorUno,puntajeParcialJugadorUno);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(1, jugadorUno.puntaje().valor());
        assertEquals(-1, jugador2.puntaje().valor());
    }

    @Test
    public void seCreaPreguntaVerdaderoFalsoPenalidadIndicandoRespuestaCorrecta(){

        Opcion opcionCorrecta = new Opcion("Verdadero");
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);


        assertEquals(opcionCorrecta.valor(), pregunta.opcionCorrecta().valor());
    }

}
