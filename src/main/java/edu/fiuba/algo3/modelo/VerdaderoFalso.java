package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

abstract class VerdaderoFalso extends Pregunta {

    public VerdaderoFalso(String enunciado, OpcionCorrecta opcionCorrecta, OpcionIncorrecta opcionIncorrecta){
        super(enunciado);
        opcionesCorrectas.add(opcionCorrecta);
        opcionesIncorrectas.add(opcionIncorrecta);
    }
    public abstract void respuestaEsCorrecta(Usuario jugador);
    public abstract void respuestaEsIncorrecta(Usuario jugador);

}