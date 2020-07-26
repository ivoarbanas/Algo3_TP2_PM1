package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

abstract class VerdaderoFalso extends Pregunta {


    public VerdaderoFalso(String enunciado, boolean esVerdadera){
        super(enunciado);
        if (esVerdadera){
            crearPreguntaVerdadera();
        }
        else {
            crearPreguntaFalsa();
        }


    }

    private void crearPreguntaVerdadera(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Falso");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
    }
    private void crearPreguntaFalsa(){
        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Falso");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Verdadero");
        opciones.add(opcionCorrecta);
        opciones.add(opcionIncorrecta);
    }
    public abstract int respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas);
    public abstract int respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas);

}