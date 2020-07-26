package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoicePenalidad extends MultipleChoice {

    private SistemaPuntaje sistemaPuntaje;

    public MultipleChoicePenalidad(String enunciado){
        super(enunciado);
        sistemaPuntaje = new SistemaPuntaje();
    }

    public int respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        return 1;
    }

    public int respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas){
        return -1;
    }

}