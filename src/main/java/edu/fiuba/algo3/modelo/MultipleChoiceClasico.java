package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoiceClasico extends MultipleChoice {


    public MultipleChoiceClasico(String enunciado){
        super(enunciado);
    }

    public int respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas){
        if(cantidadOpcionesValidas == jugador.respuestasDelUsuario.size() && cantidadOpcionesValidas == respuestasVerificadas){
            return 1;
        }
        return 0;
    }
    public int respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas){
        return 0;
    }

}