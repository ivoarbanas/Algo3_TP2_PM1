package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupChoiceTest {

    @Test
    public void seCreaPreguntaGroupChoiceConOpcionesAgrupadasCorrectamente() {
        ArrayList<Opcion> listaOpcionesGrupo1= new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesGrupoDos= new ArrayList<Opcion>();
        Opcion opcion1 = new Opcion("Uno");
        Opcion opcionDos = new Opcion("Amarillo");
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcion4);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupoDos);

        assertEquals(opcion1.valor(),pregunta.listaOpcionesGrupoUno().get(0).valor());
        assertEquals(opcionTres.valor(),pregunta.listaOpcionesGrupoUno().get(1).valor());
        assertEquals(opcionDos.valor(),pregunta.listaOpcionesGrupoDos().get(0).valor());
        assertEquals(opcion4.valor(),pregunta.listaOpcionesGrupoDos().get(1).valor());
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
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcion4);
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
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcion4);
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
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcion4);
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
        Opcion opcionTres = new Opcion("Seis");
        Opcion opcion4 = new Opcion("Rojo");
        listaOpcionesGrupo1.add(opcion1);
        listaOpcionesGrupo1.add(opcionTres);
        listaOpcionesGrupoDos.add(opcionDos);
        listaOpcionesGrupoDos.add(opcion4);
        GroupChoice pregunta = new GroupChoice("Numeros", "Colores", listaOpcionesGrupo1, listaOpcionesGrupoDos);

        // solo cargo respuestas del grupo1
        respuestasDelUsuario.add(opcion1);
        respuestasDelUsuario.add(opcionDos);
        respuestasDelUsuario.add(opcionTres);
        jugador1.cargarRespuestas(respuestasDelUsuario);
        Puntaje puntajeJugador1 = pregunta.calcularPuntajeParaRespuesta(jugador1.respuestas());
        sistemaPuntaje.cambiarPuntaje(jugador1, puntajeJugador1);

        assertEquals(0,jugador1.puntaje().valor());
        assertEquals(3,jugador1.respuestas().size());

    }
}
