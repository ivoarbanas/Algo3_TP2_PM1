package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    @Test
    public void seCreaPreguntaOrderedChoiceConUnaListaDeOpcionesOrdenadas() {
        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcion2 = new Opcion("Cuatro");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Diez");
        listaOpcionesOrdenadas.add(opcion1);
        listaOpcionesOrdenadas.add(opcion2);
        listaOpcionesOrdenadas.add(opcion3);
        listaOpcionesOrdenadas.add(opcion4);
        OrderedChoice pregunta = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        assertEquals(opcion1.valor(),pregunta.opciones.get(0).valor());
        assertEquals(opcion2.valor(),pregunta.opciones.get(1).valor());
        assertEquals(opcion3.valor(),pregunta.opciones.get(2).valor());
        assertEquals(opcion4.valor(),pregunta.opciones.get(3).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestaOrdenadaYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcion2 = new Opcion("Cuatro");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Diez");
        listaOpcionesOrdenadas.add(opcion1);
        listaOpcionesOrdenadas.add(opcion2);
        listaOpcionesOrdenadas.add(opcion3);
        listaOpcionesOrdenadas.add(opcion4);
        OrderedChoice pregunta = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcion2);
        respuestasDelUsuario.add(opcion3);
        respuestasDelUsuario.add(opcion4);
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
        Opcion opcion2 = new Opcion("Cuatro");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Diez");
        listaOpcionesOrdenadas.add(opcion1);
        listaOpcionesOrdenadas.add(opcion2);
        listaOpcionesOrdenadas.add(opcion3);
        listaOpcionesOrdenadas.add(opcion4);
        OrderedChoice pregunta = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcion2);
        respuestasDelUsuario.add(opcion4);
        respuestasDelUsuario.add(opcion3);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(4,jugador1.respuestas().size());

    }
}
