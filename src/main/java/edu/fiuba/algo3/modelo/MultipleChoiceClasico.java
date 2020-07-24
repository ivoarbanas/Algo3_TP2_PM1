package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoiceClasico extends MultipleChoice {

    private SistemaPuntaje sistemaPuntaje;

    public MultipleChoiceClasico(String enunciado){
        super(enunciado);
        sistemaPuntaje = new SistemaPuntaje();
    }

    public void respuestaEsCorrecta(Usuario jugador){
        sistemaPuntaje.cambiarPuntaje(jugador,1);
    }

    public void respuestaEsIncorrecta(Usuario jugador){
        // no hace nada
    }

}