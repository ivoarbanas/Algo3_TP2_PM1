package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

public class MultipleChoiceParcial extends MultipleChoice {


    public MultipleChoiceParcial(String enunciado){
        super(enunciado);
    }

    public int respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas) {
        if (jugador.sonTodasCorrectas()) {
            return 1;
        }
        return 0;
    }

    public int respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas) {
        if (jugador.sonTodasCorrectas()) {
            jugador.respuestaIncorrecta();
            return -respuestasVerificadas + 1;
        }
        return 0;
    }
}