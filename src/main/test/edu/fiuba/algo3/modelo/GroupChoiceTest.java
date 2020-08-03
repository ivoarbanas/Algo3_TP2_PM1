package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void seCreaPreguntaGroupChoiceConOpcionesAgrupadasCorrectamente() {
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupo2= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcion2 = new Opcion("Amarillo");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcion3);
        listaOpcionesGrupo2.add(opcion2);
        listaOpcionesGrupo2.add(opcion4);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupo2);

        assertEquals(opcion1.valor(),pregunta.listaOpcionesGrupo1.get(0).valor());
        assertEquals(opcion3.valor(),pregunta.listaOpcionesGrupo1.get(1).valor());
        assertEquals(opcion2.valor(),pregunta.listaOpcionesGrupo2.get(0).valor());
        assertEquals(opcion4.valor(),pregunta.listaOpcionesGrupo2.get(1).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestaGroupChoiceYAsignaPuntajeCorrectamente() {
        SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
        Usuario jugador1 = new Usuario("Manuel");
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupo2= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcion2 = new Opcion("Amarillo");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcion3);
        listaOpcionesGrupo2.add(opcion2);
        listaOpcionesGrupo2.add(opcion4);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupo2);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcion3);
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
        ArrayList<Opcion> listaOpcionesGrupo2= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcion2 = new Opcion("Amarillo");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcion3);
        listaOpcionesGrupo2.add(opcion2);
        listaOpcionesGrupo2.add(opcion4);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupo2);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcion2);
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
        ArrayList<Opcion> listaOpcionesGrupo2= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcion2 = new Opcion("Amarillo");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcion3);
        listaOpcionesGrupo2.add(opcion2);
        listaOpcionesGrupo2.add(opcion4);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupo2);

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
        ArrayList<Opcion> listaOpcionesGrupo2= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuario= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcion2 = new Opcion("Amarillo");
        Opcion opcion3 = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcion3);
        listaOpcionesGrupo2.add(opcion2);
        listaOpcionesGrupo2.add(opcion4);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupo2);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcion2);
        respuestasDelUsuario.add(opcion3);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(3,jugador1.respuestas().size());

    }
}
