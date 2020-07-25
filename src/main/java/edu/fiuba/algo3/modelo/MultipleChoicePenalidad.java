package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoicePenalidad extends MultipleChoice {

    private SistemaPuntaje sistemaPuntaje;

    public MultipleChoicePenalidad(String enunciado){
        super(enunciado);
        sistemaPuntaje = new SistemaPuntaje();
    }

    public void respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        sistemaPuntaje.cambiarPuntaje(jugador,1);
    }

    public void respuestaEsIncorrecta(Usuario jugador){
        sistemaPuntaje.cambiarPuntaje(jugador,-1);
    }

}