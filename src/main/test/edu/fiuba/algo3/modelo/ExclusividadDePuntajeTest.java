package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExclusividadDePuntajeTest {

    @Test
    public void UnJugadorSoloAplicaExclusividadAciertaYLosPuntosSeAsignanCorrectamente(){
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuarioUno = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuarioDos = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcionUno = new Opcion("Marge");
        Opcion opcionDos = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuarioUno.add(opcionUno);
        respuestasDeUsuarioUno.add(opcionDos);
        respuestasDeUsuarioUno.add(opcion3);
        respuestasDeUsuarioDos.add(opcionCuatro);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuarioUno);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuarioDos);
        kahoot.verificarRonda();

        assertEquals(2, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());
    }

    @Test
    public void HayDosRondasYUnJugadorUsaSusDosExclusividadesYLosPuntosSeAsignanCorrectamente() {
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuarioUno = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuarioDos = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcionUno = new Opcion("Marge");
        Opcion opcionDos = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcionUno);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuarioUno.add(opcionUno);
        respuestasDeUsuarioUno.add(opcionDos);
        respuestasDeUsuarioUno.add(opcion3);
        respuestasDeUsuarioDos.add(opcionCuatro);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuarioUno);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuarioDos);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();

        ArrayList<Opcion> listaRespuestaJugadorUno = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugadorDos = new ArrayList<Opcion>();

        VerdaderoFalsoClasico preguntaDos = new VerdaderoFalsoClasico("Aprobé el parcial",true);

        Opcion opcionUnoPreguntaDos = new Opcion("Verdadero");
        Opcion opcionDosPreguntaDos = new Opcion("Falso");
        listaRespuestaJugadorUno.add(opcionUnoPreguntaDos);
        listaRespuestaJugadorDos.add(opcionDosPreguntaDos);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(preguntaDos);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugadorUno);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugadorDos);
        kahoot.verificarRonda();

        assertEquals(4, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());


    }

    @Test
    public void HayTresondasYUnJugadorIntentaUsarTresExclusividadesYLosPuntosSeAsignanCorrectamente() {
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Joaquin");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuarioDos = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcionDos = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcionDos);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcionDos);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuarioDos.add(opcionCuatro);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuarioDos);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();


        ArrayList<Opcion> listaRespuestaJugador1 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaRespuestaJugadorDos = new ArrayList<Opcion>();

        VerdaderoFalsoClasico preguntaDos = new VerdaderoFalsoClasico("Aprobé el parcial",true);

        Opcion opcion1PreguntaDos = new Opcion("Verdadero");
        Opcion opcionDosPreguntaDos = new Opcion("Falso");
        listaRespuestaJugador1.add(opcion1PreguntaDos);
        listaRespuestaJugadorDos.add(opcionDosPreguntaDos);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(preguntaDos);
        kahoot.jugadores().get(0).cargarRespuestas(listaRespuestaJugador1);
        kahoot.jugadores().get(1).cargarRespuestas(listaRespuestaJugadorDos);
        kahoot.verificarRonda();
        kahoot.cambiarRonda();


        ArrayList<Opcion> listaOpcionesOrdenadas= new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuarioUnoPreguntaTres = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDelUsuarioDosPreguntaTres = new ArrayList<Opcion>();

        Opcion opcionUnoPreguntaTres = new Opcion("Uno");
        Opcion opcionDosPreguntaTres = new Opcion("Cuatro");
        Opcion opcionTresPreguntaTres = new Opcion("Seis");
        Opcion opcionCuatroPreguntaTres = new Opcion("Diez");

        listaOpcionesOrdenadas.add(opcionUnoPreguntaTres);
        listaOpcionesOrdenadas.add(opcionDosPreguntaTres);
        listaOpcionesOrdenadas.add(opcionTresPreguntaTres);
        listaOpcionesOrdenadas.add(opcionCuatroPreguntaTres);

        OrderedChoice pregunta3 = new OrderedChoice("Ordenar numeros de menor a mayor", listaOpcionesOrdenadas);

        respuestasDelUsuarioUnoPreguntaTres.add(opcionUnoPreguntaTres);
        respuestasDelUsuarioUnoPreguntaTres.add(opcionDosPreguntaTres);
        respuestasDelUsuarioUnoPreguntaTres.add(opcionTresPreguntaTres);
        respuestasDelUsuarioUnoPreguntaTres.add(opcionCuatroPreguntaTres);
        respuestasDelUsuarioDosPreguntaTres.add(opcionUnoPreguntaTres);
        respuestasDelUsuarioDosPreguntaTres.add(opcionDosPreguntaTres);
        respuestasDelUsuarioDosPreguntaTres.add(opcionCuatroPreguntaTres);
        respuestasDelUsuarioDosPreguntaTres.add(opcionTresPreguntaTres);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta3);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDelUsuarioUnoPreguntaTres);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDelUsuarioDosPreguntaTres);
        kahoot.verificarRonda();

        assertEquals(5, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());

    }

    @Test
    public void DosJugadoresUtilizanExclusividadDePuntajePeroUnoFallaYLosPuntosSeAsignanCorrectamente(){
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
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcionCuatro);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();
        kahoot.jugadores().get(1).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();

        assertEquals(4, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());
    }

    @Test
    public void DosJugadoresUtilizanExclusividadDePuntajeYNingunoFallaYLosPuntosSeAsignanCorrectamente(){
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
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion1);
        respuestasDeUsuario2.add(opcion2);
        respuestasDeUsuario2.add(opcion3);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();
        kahoot.jugadores().get(1).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();

        assertEquals(1, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(1, kahoot.jugadores().get(1).puntaje().valor());
    }

    @Test
    public void DosJugadoresUtilizanExclusividadDePuntajeYAmbosFallanYLosPuntosSeAsignanCorrectamente(){
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
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario2.add(opcion2);
        respuestasDeUsuario2.add(opcion3);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();
        kahoot.jugadores().get(1).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();

        assertEquals(0, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(0, kahoot.jugadores().get(1).puntaje().valor());
    }

    @Test
    public void UnJugadorActivaExclusividadDePuntajeYEsteFallaPeroElOtroAciertaYLosPuntosSeAsignanCorrectamente(){
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
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario2.add(opcion1);
        respuestasDeUsuario2.add(opcion2);
        respuestasDeUsuario2.add(opcion3);


        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);
        kahoot.verificarRonda();

        assertEquals(0, kahoot.jugadores().get(0).puntaje().valor());
        assertEquals(1, kahoot.jugadores().get(1).puntaje().valor());
    }

    @Test
    public void UnJugadorActivaExclusividadDePuntajeYMultiplicadorX3YAciertaYLosPuntosSeAsignanCorrectamente(){
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Luchito");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuario2 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcion2 = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion3);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();
        kahoot.jugadores().get(0).utilizarMultiplicadorX3();


        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);

        kahoot.verificarRonda();

        assertEquals(2, kahoot.jugadores().get(0).puntaje().valor());

    }

    @Test
    public void UnJugadorActivaExclusividadDePuntajePeroEnPreguntaQueNoDebeYAciertaYLosPuntosSeAsignanCorrectamente(){
        Kahoot kahoot = new Kahoot();

        kahoot.crearJugador("Jorgito");
        kahoot.crearJugador("Luchito");

        ArrayList<Opcion> respuestasDeUsuario1 = new ArrayList<Opcion>();
        ArrayList<Opcion> respuestasDeUsuario2 = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesCorrectas = new ArrayList<Opcion>();
        ArrayList<Opcion> listaOpcionesIncorrectas = new ArrayList<Opcion>();

        Opcion opcion1 = new Opcion("Marge");
        Opcion opcion2 = new Opcion("Homero");
        Opcion opcion3 = new Opcion("Rafa");
        Opcion opcionCuatro = new Opcion("Juan Manuel Serrat");

        listaOpcionesCorrectas.add(opcion1);
        listaOpcionesCorrectas.add(opcion2);
        listaOpcionesCorrectas.add(opcion3);
        listaOpcionesIncorrectas.add(opcionCuatro);

        MultipleChoicePenalidad pregunta = new MultipleChoicePenalidad("Cual de estos es un personaje de los simpsons", listaOpcionesCorrectas, listaOpcionesIncorrectas);

        respuestasDeUsuario1.add(opcion1);
        respuestasDeUsuario1.add(opcion2);
        respuestasDeUsuario1.add(opcion3);
        respuestasDeUsuario2.add(opcion3);

        kahoot.jugadores().get(0).utilizarExclusividadPuntaje();

        kahoot.cargarPregunta(pregunta);
        kahoot.jugadores().get(0).cargarRespuestas(respuestasDeUsuario1);
        kahoot.jugadores().get(1).cargarRespuestas(respuestasDeUsuario2);

        kahoot.verificarRonda();

        assertEquals(3, kahoot.jugadores().get(0).puntaje().valor());

    }
}
