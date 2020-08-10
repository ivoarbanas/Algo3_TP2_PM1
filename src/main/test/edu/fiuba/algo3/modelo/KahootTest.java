package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        Opcion opcionUno = new Opcion("Verdadero");
        Opcion opcionDos = new Opcion("Falso");
        ArrayList <Opcion> listaRespuestaJugadorUno = new ArrayList<Opcion>();
        ArrayList <Opcion> listaRespuestaJugadorDos = new ArrayList<Opcion>();
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Es correcto este test?", true);
        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");
        listaRespuestaJugadorUno.add(opcionUno);
        listaRespuestaJugadorDos.add(opcionDos);

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugadorUno);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugadorDos);
        kahoot.verificarRonda();

        assertEquals(1, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasTresCorrectasEnMultipleChoiceClasicoYAsignaPuntajeCorrectamenteAplicandoMultiplicadorX2() {
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

}