package edu.fiuba.algo3.modelo;


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

    public Puntaje aplicarExclusividad(Puntaje puntajeAMultiplicar, ExclusividadDePuntaje exclusividadDePuntaje){
        return pregunta.calcularPuntajeConExclusividad(puntajeAMultiplicar, exclusividadDePuntaje);
    }

    public Pregunta pregunta() {
        return pregunta;
    }
}
