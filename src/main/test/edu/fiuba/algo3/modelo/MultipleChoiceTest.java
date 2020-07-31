package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void seCreaPreguntaMultipleChoiceClasicoIndicandoRespuestaCorrecta() {
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("Uno");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionCorrecta3);
        pregunta.agregarOpcion(opcionIncorrecta1);


        assertEquals(opcionCorrecta1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionCorrecta2.valor(),pregunta.opciones().get(1).valor());
        assertEquals(opcionCorrecta3.valor(),pregunta.opciones().get(2).valor());
    }


    @Test
    public void seCreaPreguntaMultipleChoiceParcialIndicandoRespuestaCorrecta() {
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Diecinueve");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Tres mil");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Uno");
        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionIncorrecta);


        assertEquals(opcionCorrecta1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionCorrecta2.valor(),pregunta.opciones().get(1).valor());
    }


    @Test
    public void recibeUnaListaDeRespuestasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("Uno");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionCorrecta3);
        pregunta.agregarOpcion(opcionIncorrecta1);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);
        jugador1.elegirRespuestaParaPrueba(pregunta,2);
        jugador1.elegirRespuestaParaPrueba(pregunta,3);
        jugador2.elegirRespuestaParaPrueba(pregunta,0);
        jugador2.elegirRespuestaParaPrueba(pregunta,1);
        jugador2.elegirRespuestaParaPrueba(pregunta,2);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        Puntaje puntajeParcialJugador2 = verificador.verificar(pregunta, jugador2);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(4, jugador1.respuestasDelUsuario.size());
        assertEquals(1, jugador2.puntaje().valor());
        assertEquals(3, jugador2.respuestasDelUsuario.size());
    }

    @Test
    public void recibeUnaListaDeDosRespuestasCorrectasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);

        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(2, jugador1.respuestasDelUsuario.size());
    }

    @Test
    public void recibeUnaListaDeDosRespuestasInCorrectasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("Uno");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionCorrecta3);
        pregunta.agregarOpcion(opcionIncorrecta1);
        jugador1.elegirRespuestaParaPrueba(pregunta,2);
        jugador1.elegirRespuestaParaPrueba(pregunta,3);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(2, jugador1.respuestasDelUsuario.size());
    }



    @Test
    public void recibeUnaListaDeRespuestasEnMultipleChoiceParcialYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("Uno");
        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionCorrecta3);
        pregunta.agregarOpcion(opcionIncorrecta1);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);
        jugador1.elegirRespuestaParaPrueba(pregunta,2);
        jugador1.elegirRespuestaParaPrueba(pregunta,3);
        jugador2.elegirRespuestaParaPrueba(pregunta,0);
        jugador2.elegirRespuestaParaPrueba(pregunta,1);
        jugador2.elegirRespuestaParaPrueba(pregunta,2);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        Puntaje puntajeParcialJugador2 = verificador.verificar(pregunta, jugador2);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(4,jugador1.respuestasDelUsuario.size());
        assertEquals(3,jugador2.puntaje().valor());
        assertEquals(3, jugador2.respuestasDelUsuario.size());
    }

    @Test
    public void recibeUnaListaDeDosRespuestasCorrectasEnMultipleChoiceParcialYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(2,jugador1.puntaje().valor());
        assertEquals(2,jugador1.respuestasDelUsuario.size());
    }

    @Test
    public void recibeUnaListaDeDosRespuestasIncorrectasEnMultipleChoiceParcialYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("Uno");
        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionCorrecta3);
        pregunta.agregarOpcion(opcionIncorrecta1);
        jugador1.elegirRespuestaParaPrueba(pregunta,2);
        jugador1.elegirRespuestaParaPrueba(pregunta,3);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(2, jugador1.respuestasDelUsuario.size());
    }

    @Test
    public void seCreaPreguntaMultipleChoicePenalidadIndicandoRespuestaCorrecta() {
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Diecinueve");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Tres mil");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Uno");
        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionIncorrecta);


        assertEquals(opcionCorrecta1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionCorrecta2.valor(),pregunta.opciones().get(1).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("Uno");
        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionCorrecta3);
        pregunta.agregarOpcion(opcionIncorrecta1);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);
        jugador1.elegirRespuestaParaPrueba(pregunta,2);
        jugador1.elegirRespuestaParaPrueba(pregunta,3);
        jugador2.elegirRespuestaParaPrueba(pregunta,0);
        jugador2.elegirRespuestaParaPrueba(pregunta,1);
        jugador2.elegirRespuestaParaPrueba(pregunta,2);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        Puntaje puntajeParcialJugador2 = verificador.verificar(pregunta, jugador2);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);
        sistemaPuntaje.cambiarPuntaje(jugador2,puntajeParcialJugador2);


        assertEquals(2,jugador1.puntaje().valor());
        assertEquals(4,jugador1.respuestasDelUsuario.size());
        assertEquals(3,jugador2.puntaje().valor());
        assertEquals(3, jugador2.respuestasDelUsuario.size());
    }

    @Test
    public void recibeUnaListaDeDosRespuestasCorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        jugador1.elegirRespuestaParaPrueba(pregunta,0);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(2,jugador1.puntaje().valor());
        assertEquals(2,jugador1.respuestasDelUsuario.size());
    }

    @Test
    public void recibeUnaListaDeDosRespuestasIncorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionIncorrecta opcionIncorrecta1 = new OpcionIncorrecta("Dos");
        OpcionIncorrecta opcionIncorrecta2 = new OpcionIncorrecta("Uno");
        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionIncorrecta1);
        pregunta.agregarOpcion(opcionIncorrecta2);
        jugador1.elegirRespuestaParaPrueba(pregunta,1);
        jugador1.elegirRespuestaParaPrueba(pregunta,2);
        jugador1.elegirRespuestaParaPrueba(pregunta,3);
        Verificador verificador = new Verificador();
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Puntaje puntajeParcialJugador1 = verificador.verificar(pregunta, jugador1);
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(-1, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestasDelUsuario.size());
    }
}
