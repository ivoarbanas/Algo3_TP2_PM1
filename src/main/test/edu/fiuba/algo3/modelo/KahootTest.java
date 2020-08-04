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
        Opcion opcion1 = new Opcion("Verdadero");
        Opcion opcion2 = new Opcion("Falso");
        ArrayList <Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList <Opcion> listaRespuestaJugador2 = new ArrayList<Opcion>();
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Es correcto este test?", true);
        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");
        listaRespuestaJugador1.add(opcion1);
        listaRespuestaJugador2.add(opcion2);

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugador1);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugador2);
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
        kahoot.jugadores().get(1).utilizarMultiplicadorX3();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();

        assertEquals(6, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(-3, kahoot.jugadores().get(1).puntaje().valor());
    }
}