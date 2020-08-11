package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Ronda {

    private Pregunta pregunta;

    public void cargarPregunta(Pregunta preguntaACargar){
        pregunta = preguntaACargar;
    }

    public Puntaje obtenerPuntajeJugador(Usuario jugador) {
       return pregunta.calcularPuntajeParaRespuesta(jugador.respuestas());
    }

    public Puntaje aplicarMultiplicador(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return pregunta.calcularPuntajeConMultiplicador(puntajeAMultiplicar, jugadorAfectado.getMultiplicador());
    }

    public Puntaje aplicarExclusividadDuplicada(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return pregunta.duplicarPuntajeConExclusividad(puntajeAMultiplicar, jugadorAfectado.getExclusividad());
    }

    public Puntaje aplicarExclusividadCuadruplicado(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return pregunta.cuadruplicarPuntajeConExclusividad(puntajeAMultiplicar, jugadorAfectado.getExclusividad());
    }

    public Pregunta pregunta() {
        return pregunta;
    }
}
