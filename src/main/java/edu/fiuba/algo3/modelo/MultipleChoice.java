package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;

abstract class MultipleChoice extends Pregunta {

    protected int cantidadDeOpciones;

    public MultipleChoice(String enunciado){
        super(enunciado);
        cantidadDeOpciones = 0;
    }

    public abstract void respuestaEsCorrecta(Usuario jugador);
    public abstract void respuestaEsIncorrecta(Usuario jugador);

    public void agregarOpcionCorrecta(String opcionCorrecta){
        if( cantidadDeOpciones < 6) {
            OpcionCorrecta opcion = new OpcionCorrecta(opcionCorrecta);
            opcionesCorrectas.add(opcion);
            cantidadDeOpciones++;
        }
    }

    public void agregarOpcionIncorrecta(String opcionIncorrecta){
        if( cantidadDeOpciones < 6) {
            OpcionIncorrecta opcion = new OpcionIncorrecta(opcionIncorrecta);
            opcionesIncorrectas.add(opcion);
            cantidadDeOpciones++;
        }
    }


}