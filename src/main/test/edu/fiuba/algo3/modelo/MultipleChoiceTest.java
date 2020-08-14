package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    // TEST MC CLASICO

    @Test
    public void seCreaPreguntaMultipleChoiceClasicoIndicandoRespuestaCorrecta() {
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        assertEquals(opcionCorrecta1.valor(),pregunta.listaOpcionesCorrectas.get(0).valor());
        assertEquals(opcionCorrectaDos.valor(),pregunta.listaOpcionesCorrectas.get(1).valor());
        assertEquals(opcionCorrectaTres.valor(),pregunta.listaOpcionesCorrectas.get(2).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionCorrectaTres);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasDosCorrectasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(2, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasUnaIncorrectaCorrectasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionCorrectaTres);
        respuestasDeUsuario.add(opcionIncorrecta1);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(4, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasDosCorrectasUnaIncorrectaCorrectasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionIncorrecta1);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestas().size());
    }

    // TEST MC PARCIAL

    @Test
    public void seCreaPreguntaMultipleChoiceParcialIndicandoRespuestaCorrecta() {
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        assertEquals(opcionCorrecta1.valor(), pregunta.listaOpcionesCorrectas.get(0).valor());
        assertEquals(opcionCorrectaDos.valor(), pregunta.listaOpcionesCorrectas.get(1).valor());
        assertEquals(opcionCorrectaTres.valor(), pregunta.listaOpcionesCorrectas.get(2).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasEnMultipleChoiceParcialYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionCorrectaTres);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(3, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasDosCorrectasEnMultipleChoiceParcialYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(2, jugador1.puntaje().valor());
        assertEquals(2, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasUnaIncorrectaCorrectasEnMultipleChoiceParcialYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionCorrectaTres);
        respuestasDeUsuario.add(opcionIncorrecta1);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(4, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasDosCorrectasUnaIncorrectaCorrectasEnMultipleChoiceParcialYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrectaUno = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrectaTres = new Opcion("Seis");
        Opcion opcionIncorrectaUno = new Opcion("Uno");

        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrectaUno);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrectaTres);
        pregunta.cargarOpcionIncorrecta(opcionIncorrectaUno);

        respuestasDeUsuario.add(opcionCorrectaUno);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionIncorrectaUno);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(0, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestas().size());
    }

    // TEST MC PENALIDAD

    @Test
    public void seCreaPreguntaMultipleChoicePenalidadIndicandoRespuestaCorrecta() {
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrecta2 = new Opcion("Dieciseis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrecta2);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        assertEquals(opcionCorrecta1.valor(), pregunta.listaOpcionesCorrectas.get(0).valor());
        assertEquals(opcionCorrecta2.valor(), pregunta.listaOpcionesCorrectas.get(1).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrecta2 = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrecta2);
        pregunta.cargarOpcionCorrecta(opcionCorrecta3);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrecta2);
        respuestasDeUsuario.add(opcionCorrecta3);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(3, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasDosCorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrecta2 = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrecta2);
        pregunta.cargarOpcionCorrecta(opcionCorrecta3);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrecta2);
        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(2, jugador1.puntaje().valor());
        assertEquals(2, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasUnaIncorrectaCorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrectaUno = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrectaUno);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrecta3);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrectaUno);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionCorrecta3);
        respuestasDeUsuario.add(opcionIncorrecta1);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(2, jugador1.puntaje().valor());
        assertEquals(4, jugador1.respuestas().size());
    }

    @Test
    public void recibeUnaListaDeRespuestasDosCorrectasUnaIncorrectaCorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco");

        pregunta.cargarOpcionCorrecta(opcionCorrecta1);
        pregunta.cargarOpcionCorrecta(opcionCorrectaDos);
        pregunta.cargarOpcionCorrecta(opcionCorrecta3);
        pregunta.cargarOpcionIncorrecta(opcionIncorrecta1);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
        respuestasDeUsuario.add(opcionIncorrecta1);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestas().size());
    }
}
