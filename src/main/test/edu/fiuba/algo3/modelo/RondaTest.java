package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    @Test
    public void HayUnaSolaRondaYLosPuntosSeAsignanCorrectamente(){
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuario2 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcion2 = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcion4 = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcion4);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion4);

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();

        assertEquals(3, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(-1, kahoot.jugadores().get(1).puntaje().valor());
    }

    @Test
    public void HayDosRondasYLosPuntosSeAsignanCorrectamente() {
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuario2 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcion2 = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcion4 = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcion4);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion4);

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();

        ArrayList<Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();

        VerdaderoFalsoPenalidad pregunta2 = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);

        Opcion opcion1PreguntaDos = new Opcion("Verdadero");
        Opcion opcion2PreguntaDos = new Opcion("Falso");
        listaRespuestaJugador1.add(opcion1PreguntaDos);
        listaRespuestaJugador2.add(opcion2PreguntaDos);

        kahoot.cargarPregunta(pregunta2);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugador1);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugador2);
        kahoot.verificarRonda();

        assertEquals(4, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(-2, kahoot.jugadores().get(1).puntaje().valor());


    }

    @Test
    public void HayDosRondasYAmbosUsanMultiplicadoresEnUnaPreguntaYLosPuntosSeAsignanCorrectamente() {
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuario2 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcion2 = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcion4 = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcion4);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion4);

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();

        ArrayList<Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();

        VerdaderoFalsoPenalidad pregunta2 = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);

        Opcion opcion1PreguntaDos = new Opcion("Verdadero");
        Opcion opcion2PreguntaDos = new Opcion("Falso");
        listaRespuestaJugador1.add(opcion1PreguntaDos);
        listaRespuestaJugador2.add(opcion2PreguntaDos);

        kahoot.jugadores().get(0).utilizarMultiplicadorX2();
        kahoot.jugadores().get(1).utilizarMultiplicadorX3();

        kahoot.cargarPregunta(pregunta2);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugador1);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugador2);
        kahoot.verificarRonda();

        assertEquals(5, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(-4, kahoot.jugadores().get(1).puntaje().valor());


    }

    @Test
    public void HayTresondasYAmbosUsanMultiplicadoresPeroUnoEnPreguntaQueNoDebeYLosPuntosSeAsignanCorrectamente() {
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuario2 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcion2 = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcion4 = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcion4);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion4);

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();


        ArrayList<Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();

        VerdaderoFalsoPenalidad pregunta2 = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);

        Opcion opcion1PreguntaDos = new Opcion("Verdadero");
        Opcion opcion2PreguntaDos = new Opcion("Falso");
        listaRespuestaJugador1.add(opcion1PreguntaDos);
        listaRespuestaJugador2.add(opcion2PreguntaDos);

        kahoot.jugadores().get(0).utilizarMultiplicadorX2();

        kahoot.cargarPregunta(pregunta2);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugador1);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugador2);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();


        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario1Pregunta3 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario2Pregunta3 = new ArrayList<Opcion>();

        Opcion opcion1Pregunta3 = new Opcion("Uno");
        Opcion opcion2Pregunta3 = new Opcion("Cuatro");
        Opcion opcion3Pregunta3 = new Opcion("Seis");
        Opcion opcion4Pregunta3 = new Opcion("Diez");

        listaOpcionesOrdenadas.add(opcion1Pregunta3);
        listaOpcionesOrdenadas.add(opcion2Pregunta3);
        listaOpcionesOrdenadas.add(opcion3Pregunta3);
        listaOpcionesOrdenadas.add(opcion4Pregunta3);

        OrderedChoice pregunta3 = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        respuestasDelUsuario1Pregunta3.add(opcion1Pregunta3);
        respuestasDelUsuario1Pregunta3.add(opcion2Pregunta3);
        respuestasDelUsuario1Pregunta3.add(opcion3Pregunta3);
        respuestasDelUsuario1Pregunta3.add(opcion4Pregunta3);
        respuestasDelUsuario2Pregunta3.add(opcion1Pregunta3);
        respuestasDelUsuario2Pregunta3.add(opcion2Pregunta3);
        respuestasDelUsuario2Pregunta3.add(opcion4Pregunta3);
        respuestasDelUsuario2Pregunta3.add(opcion3Pregunta3);

        kahoot.jugadores().get(1).utilizarMultiplicadorX2();

        kahoot.cargarPregunta(pregunta3);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDelUsuario1Pregunta3);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDelUsuario2Pregunta3);
        kahoot.verificarRonda();

        assertEquals(6, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(-2, kahoot.jugadores().get(1).puntaje().valor());


    }

    @Test
    public void HayDosRondasYUnJugadorUsaDosVecesElMismoMultiplicadorPuntosSeAsignanCorrectamente() {
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuario2 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcion2 = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcion4 = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcion4);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion4);

        kahoot.jugadores().get(0).utilizarMultiplicadorX2();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();


        ArrayList<Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();

        VerdaderoFalsoPenalidad pregunta2 = new VerdaderoFalsoPenalidad("Aprobé el parcial",true);

        Opcion opcion1PreguntaDos = new Opcion("Verdadero");
        Opcion opcion2PreguntaDos = new Opcion("Falso");
        listaRespuestaJugador1.add(opcion1PreguntaDos);
        listaRespuestaJugador2.add(opcion2PreguntaDos);

        kahoot.jugadores().get(0).utilizarMultiplicadorX2();

        kahoot.cargarPregunta(pregunta2);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugador1);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugador2);
        kahoot.verificarRonda();

        assertEquals(7, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(-2, kahoot.jugadores().get(1).puntaje().valor());


    }

}