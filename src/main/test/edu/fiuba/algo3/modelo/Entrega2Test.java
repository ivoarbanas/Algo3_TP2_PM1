package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Entrega2Test {


    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamenteAplicandoMultiplicadorX2() {
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuarioDos = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcionDos = new Opcion("Homero");
        Opcion opcionTres = new Opcion("Rafa");
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcionTres);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcionDos);
        respuestasDeUsuario1.add(opcionTres);
        respuestasDeUsuarioDos.add(opcionCuatro);

        kahoot.jugadores().get(0).utilizarMultiplicadorX2();
        kahoot.jugadores().get(1).utilizarMultiplicadorX3();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuarioDos);
        kahoot.verificarRonda();

        assertEquals(6, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(-3, kahoot.jugadores().get(1).puntaje().valor());
    }



    @Test
    public void seCreaPreguntaOrderedChoiceConUnaListaDeOpcionesOrdenadas() {
        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Cuatro");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Diez");
        listaOpcionesOrdenadas.add(opcion1);
        listaOpcionesOrdenadas.add(opcionDos);
        listaOpcionesOrdenadas.add(opcionTres);
        listaOpcionesOrdenadas.add(opcionCuatro);
        OrderedChoice pregunta = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        assertEquals(opcion1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionDos.valor(),pregunta.opciones().get(1).valor());
        assertEquals(opcionTres.valor(),pregunta.opciones().get(2).valor());
        assertEquals(opcionCuatro.valor(),pregunta.opciones().get(3).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestaOrdenadaYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Cuatro");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Diez");
        listaOpcionesOrdenadas.add(opcion1);
        listaOpcionesOrdenadas.add(opcionDos);
        listaOpcionesOrdenadas.add(opcionTres);
        listaOpcionesOrdenadas.add(opcionCuatro);
        OrderedChoice pregunta = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcionDos);
        respuestasDelUsuario.add(opcionTres);
        respuestasDelUsuario.add(opcionCuatro);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(1,jugador1.puntaje().valor());
        assertEquals(4,jugador1.respuestas().size());

    }

    @Test
    public void recibeUnaListaDeRespuestaDesordenadaYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Cuatro");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Diez");
        listaOpcionesOrdenadas.add(opcion1);
        listaOpcionesOrdenadas.add(opcionDos);
        listaOpcionesOrdenadas.add(opcionTres);
        listaOpcionesOrdenadas.add(opcionCuatro);
        OrderedChoice pregunta = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcionDos);
        respuestasDelUsuario.add(opcionCuatro);
        respuestasDelUsuario.add(opcionTres);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(4,jugador1.respuestas().size());

    }
    @Test
    public void seCreaPreguntaGroupChoiceConOpcionesAgrupadasCorrectamente() {
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupoDos= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Amarillo");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcionCuatro);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupoDos);

        assertEquals(opcion1.valor(),pregunta.listaOpcionesGrupoUno().get(0).valor());
        assertEquals(opcionTres.valor(),pregunta.listaOpcionesGrupoUno().get(1).valor());
        assertEquals(opcionDos.valor(),pregunta.listaOpcionesGrupoDos().get(0).valor());
        assertEquals(opcionCuatro.valor(),pregunta.listaOpcionesGrupoDos().get(1).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestaGroupChoiceYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupoDos= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Amarillo");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcionCuatro);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupoDos);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcionTres);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(1,jugador1.puntaje().valor());
        assertEquals(2,jugador1.respuestas().size());

    }

    @Test
    public void recibeUnaListaDeRespuestaGroupChoiceAgrupandoMalYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupoDos= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Amarillo");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcionCuatro);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupoDos);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcionDos);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(2,jugador1.respuestas().size());

    }

    @Test
    public void recibeUnaListaDeRespuestaGroupChoiceIncompletaYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupoDos= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Amarillo");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcionCuatro);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupoDos);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(1,jugador1.respuestas().size());

    }

    @Test
    public void recibeUnaListaDeRespuestaGroupChoiceAgrupandoDeMasYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupoDos= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Amarillo");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcion3);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcionCuatro);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupoDos);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcionDos);
        respuestasDelUsuario.add(opcion3);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(3,jugador1.respuestas().size());

    }

    @Test
    public void seCreaPreguntaMultipleChoicePenalidadIndicandoRespuestaCorrecta() {
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");
        listaOpcionesCorrectas.add(opcionCorrecta1);
        listaOpcionesCorrectas.add(opcionCorrectaDos);
        listaOpcionesCorrectas.add(opcionIncorrecta1);
        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        assertEquals(opcionCorrecta1.valor(), pregunta.listaOpcionesCorrectas.get(0).valor());
        assertEquals(opcionCorrectaDos.valor(), pregunta.listaOpcionesCorrectas.get(1).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasEnMultipleChoicePenalidadYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> respuestasDeUsuario = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");
        listaOpcionesCorrectas.add(opcionCorrecta1);
        listaOpcionesCorrectas.add(opcionCorrectaDos);
        listaOpcionesCorrectas.add(opcionCorrecta3);
        listaOpcionesIncorrectas.add(opcionIncorrecta1);
        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
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
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrectaDos = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");
        listaOpcionesCorrectas.add(opcionCorrecta1);
        listaOpcionesCorrectas.add(opcionCorrectaDos);
        listaOpcionesCorrectas.add(opcionCorrecta3);
        listaOpcionesIncorrectas.add(opcionIncorrecta1);
        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrectaDos);
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
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrecta2 = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");
        listaOpcionesCorrectas.add(opcionCorrecta1);
        listaOpcionesCorrectas.add(opcionCorrecta2);
        listaOpcionesCorrectas.add(opcionCorrecta3);
        listaOpcionesIncorrectas.add(opcionIncorrecta1);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrecta2);
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
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();
        Opcion opcionCorrecta1 = new Opcion("Ocho");
        Opcion opcionCorrecta2 = new Opcion("Dieciseis");
        Opcion opcionCorrecta3 = new Opcion("Seis");
        Opcion opcionIncorrecta1 = new Opcion("Uno");
        listaOpcionesCorrectas.add(opcionCorrecta1);
        listaOpcionesCorrectas.add(opcionCorrecta2);
        listaOpcionesCorrectas.add(opcionCorrecta3);
        listaOpcionesIncorrectas.add(opcionIncorrecta1);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Que numero es mayor a cinco", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario.add(opcionCorrecta1);
        respuestasDeUsuario.add(opcionCorrecta2);
        respuestasDeUsuario.add(opcionIncorrecta1);

        jugador1.cargarRespuestas(respuestasDeUsuario);

        Puntaje puntajeParcialJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1,puntajeParcialJugador1);


        assertEquals(1, jugador1.puntaje().valor());
        assertEquals(3, jugador1.respuestas().size());
    }
}
