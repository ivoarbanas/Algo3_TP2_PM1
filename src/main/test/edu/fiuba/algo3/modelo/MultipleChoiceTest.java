package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void seCreaPreguntaMultipleChoiceClasicoIndicandoRespuestaCorrecta() {
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcionCorrecta("Ocho");
        pregunta.agregarOpcionCorrecta("Dieciseis");
        pregunta.agregarOpcionCorrecta("Seis");
        pregunta.agregarOpcionIncorrecta("Uno");


        assertEquals(opcionCorrecta1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionCorrecta2.valor(),pregunta.opciones().get(1).valor());
        assertEquals(opcionCorrecta3.valor(),pregunta.opciones().get(2).valor());
    }


    @Test
    public void seCreaPreguntaMultipleChoiceParcialIndicandoRespuestaCorrecta() {
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Diecinueve");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Tres mil");
        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");
        pregunta.agregarOpcionCorrecta("Diecinueve");
        pregunta.agregarOpcionCorrecta("Tres mil");
        pregunta.agregarOpcionIncorrecta("Uno");


        assertEquals(opcionCorrecta1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionCorrecta2.valor(),pregunta.opciones().get(1).valor());
    }


    @Test
     public void recibeUnaListaDeRespuestasEnMultipleChoiceClasicoYAsignaPuntosCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcionCorrecta("Ocho");
        pregunta.agregarOpcionCorrecta("Dieciseis");
        pregunta.agregarOpcionCorrecta("Seis");
        pregunta.agregarOpcionIncorrecta("Uno");
        jugador1.elegirRespuestaParaPrueba(pregunta,0);// 0
        jugador1.elegirRespuestaParaPrueba(pregunta,1);// 1
        jugador1.elegirRespuestaParaPrueba(pregunta,2);// 2
        jugador1.elegirRespuestaParaPrueba(pregunta,3);// 3
        jugador2.elegirRespuestaParaPrueba(pregunta,0);// 0
        jugador2.elegirRespuestaParaPrueba(pregunta,1);// 1
        jugador2.elegirRespuestaParaPrueba(pregunta,2);// 2
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        int puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        int puntajeParcialJugador2 = verificador.verificar(pregunta, jugador2);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(jugador1.puntos().valor(), 0);
        assertEquals(jugador1.respuestasDelUsuario.size(), 4);
        assertEquals(1, jugador2.puntos().valor());
        assertEquals(3, jugador2.respuestasDelUsuario.size());
    }


    @Test
    public void recibeUnaListaDeRespuestasEnMultipleChoiceParcialYAsignaPuntosCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");
        pregunta.agregarOpcionCorrecta("Ocho");
        pregunta.agregarOpcionCorrecta("Dieciseis");
        pregunta.agregarOpcionCorrecta("Seis");
        pregunta.agregarOpcionIncorrecta("Uno");
        jugador1.elegirRespuestaParaPrueba(pregunta,0);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);
        jugador1.elegirRespuestaParaPrueba(pregunta,2);
        jugador1.elegirRespuestaParaPrueba(pregunta,3);
        jugador2.elegirRespuestaParaPrueba(pregunta,0);
        jugador2.elegirRespuestaParaPrueba(pregunta,1);
        jugador2.elegirRespuestaParaPrueba(pregunta,2);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        int puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        int puntajeParcialJugador2 = verificador.verificar(pregunta, jugador2);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(0,jugador1.puntos().valor());
        assertEquals(4,jugador1.respuestasDelUsuario.size());
        assertEquals(3,jugador2.puntos().valor());
        assertEquals(3, jugador2.respuestasDelUsuario.size());
    }
}
