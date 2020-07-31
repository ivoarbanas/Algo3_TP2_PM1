package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

abstract class MultipleChoice extends Pregunta {

    protected int cantidadDeOpciones;
    protected int cantidadOpcionesValidas;


    public MultipleChoice(String enunciado){
        super(enunciado);
        cantidadDeOpciones = 0;
        cantidadOpcionesValidas = 0;
    }

    public abstract Puntaje respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas);
    public abstract Puntaje respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas);

    public void agregarOpcion(Opcion opcion){
        if( cantidadDeOpciones < 6) {
            opciones.add(opcion);
            cantidadOpcionesValidas += opcion.esCorrecta();
            cantidadDeOpciones++;
        }
    }

}