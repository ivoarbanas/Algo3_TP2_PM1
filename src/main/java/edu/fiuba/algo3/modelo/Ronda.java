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
        return puntajeAMultiplicar.aplicarMultiplicador( jugadorAfectado.getMultiplicador());
    }

    public Puntaje aplicarExclusividadDuplicada(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return puntajeAMultiplicar.duplicarPuntaje( jugadorAfectado.getExclusividad() );
    }

    public Puntaje aplicarExclusividadCuadruplicado(Usuario jugadorAfectado, Puntaje puntajeAMultiplicar){
        return puntajeAMultiplicar.cuadriplicarPuntaje( jugadorAfectado.getExclusividad() );
    }

    public Pregunta pregunta() {
        return pregunta;
    }
}
