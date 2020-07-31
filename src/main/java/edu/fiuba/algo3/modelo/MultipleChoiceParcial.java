package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoiceParcial extends MultipleChoice {


    public MultipleChoiceParcial(String enunciado){
        super(enunciado);
    }

    public Puntaje respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas) {
        Puntaje puntaje = new Puntaje();
        if (jugador.sonTodasCorrectas()) {
            puntaje.cantidad(1);
            return puntaje;
        }
        puntaje.cantidad(0);
        return puntaje;
    }

    public Puntaje respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas) {
        Puntaje puntaje = new Puntaje();
        if (jugador.sonTodasCorrectas()) {
            jugador.respuestaIncorrecta();
            puntaje.cantidad(-respuestasVerificadas + 1);
            return puntaje;
        }
        puntaje.cantidad(0);
        return puntaje;
    }
}