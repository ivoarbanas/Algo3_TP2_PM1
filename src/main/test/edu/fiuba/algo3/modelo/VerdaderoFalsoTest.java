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
        Usuario jugador1 = new Usuario("Jorge");
        Usuario jugador2 = new Usuario("Ramiro");
        ArrayList<Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial",true);

        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        listaRespuestaJugador1.add(opcion1);
        listaRespuestaJugador2.add(opcion2);
        jugador1.cargarRespuestas(listaRespuestaJugador1);
        jugador2.cargarRespuestas(listaRespuestaJugador2);
        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        Puntaje puntajeParcialJugador2 = pregunta.calcularPuntajeParaRespuesta(jugador2.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);

        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(0, jugador2.puntaje().valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasEnVerdaderoFalsoPenalidadYAsignaPuntajeCorrectamente(){

        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        ArrayList<Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);

        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        listaRespuestaJugador1.add(opcion1);
        listaRespuestaJugador2.add(opcion2);
        jugador1.cargarRespuestas(listaRespuestaJugador1);
        jugador2.cargarRespuestas(listaRespuestaJugador2);
        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        Puntaje puntajeParcialJugador2 = pregunta.calcularPuntajeParaRespuesta(jugador2.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(-1, jugador2.puntaje().valor());
    }

    @Test
    public void seCreaPreguntaVerdaderoFalsoPenalidadIndicandoRespuestaCorrecta(){

        Opcion opcionCorrecta = new Opcion("Verdadero");
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);


        assertEquals(opcionCorrecta.valor(), pregunta.opcionCorrecta().valor());
    }

}
