package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {

    @Test
    public void seCreaPreguntaVerdaderoFalsoIndicandoRespuestaCorrecta(){

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Falso");
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial",true);


        assertEquals(opcionCorrecta.valor(), pregunta.opciones().get(0).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasYAsignaCorrectamentePuntajeALosJugadoresQueRespondieronCorrectamente(){
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Jorge");
        Usuario jugador2 = new Usuario("Ramiro");
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial",true);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);//elijo 0
        jugador2.elegirRespuestaParaPrueba(pregunta,1);//elijo 1
        Verificador verificador = new Verificador();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        Puntaje puntajeParcialJugador2 = verificador.verificar(pregunta, jugador2);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(0, jugador2.puntaje().valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasEnVerdaderoFalsoPenalidadYAsignaPuntajeCorrectamente(){

        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);//elijo 0
        jugador2.elegirRespuestaParaPrueba(pregunta,1);//elijo 1
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        Puntaje puntajeParcialJugador2 = verificador.verificar(pregunta, jugador2);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(-1, jugador2.puntaje().valor());
    }

    @Test
    public void seCreaPreguntaVerdaderoFalsoPenalidadIndicandoRespuestaCorrecta(){

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Falso");
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);


        assertEquals(opcionCorrecta.valor(), pregunta.opciones().get(0).valor());
    }


}
