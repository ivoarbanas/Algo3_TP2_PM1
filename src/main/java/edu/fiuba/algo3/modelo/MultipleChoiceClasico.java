package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoiceClasico extends MultipleChoice {


    public MultipleChoiceClasico(String enunciado){
        super(enunciado);
    }

    public Puntaje respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        Puntaje puntaje = new Puntaje();
        if(cantidadOpcionesValidas == jugador.respuestasDelUsuario.size() && cantidadOpcionesValidas == respuestasVerificadas){
            puntaje.cantidad(1);
            return puntaje;
        }
        puntaje.cantidad(0);
        return puntaje;
    }
    public Puntaje respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas){
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(0);
        return puntaje;
    }

}