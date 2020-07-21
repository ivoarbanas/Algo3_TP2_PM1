package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

abstract class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(String enunciado, String opcionCorrectaValor, String opcionIncorrectaValor){
        super(enunciado);
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta(opcionCorrectaValor);
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta(opcionIncorrectaValor);
        opcionesCorrectas.add(opcionCorrecta);
        opcionesIncorrectas.add(opcionIncorrecta);
    }
    public abstract void respuestaEsCorrecta(Usuario jugador);
    public abstract void respuestaEsIncorrecta(Usuario jugador);

}