package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedChoiceTest {

    @Test
    public void seCreaPreguntaOrderedChoiceConUnaListaDeOpcionesOrdenadas() {
        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        Opcion opcionUno = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Cuatro");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcionCuatro = new Opcion("Diez");
        listaOpcionesOrdenadas.add(opcionUno);
        listaOpcionesOrdenadas.add(opcionDos);
        listaOpcionesOrdenadas.add(opcionTres);
        listaOpcionesOrdenadas.add(opcionCuatro);
        OrderedChoice pregunta = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        assertEquals(opcionUno.valor(),pregunta.opciones.get(0).valor());
        assertEquals(opcionDos.valor(),pregunta.opciones.get(1).valor());
        assertEquals(opcionTres.valor(),pregunta.opciones.get(2).valor());
        assertEquals(opcionCuatro.valor(),pregunta.opciones.get(3).valor());
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
}
