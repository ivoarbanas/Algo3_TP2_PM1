package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoicePenalidad extends MultipleChoice {

    public MultipleChoicePenalidad(String enunciado){
        super(enunciado);
    }

    public Puntaje respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(1);
        return puntaje;
    }

    public Puntaje respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas){
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(-1);
        return puntaje;
    }

}