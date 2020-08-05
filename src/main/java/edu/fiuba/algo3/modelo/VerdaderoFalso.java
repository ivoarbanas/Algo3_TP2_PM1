package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class VerdaderoFalso extends Pregunta {

    Opcion opcionCorrecta;
    Opcion opcionIncorrecta;

    public VerdaderoFalso(String enunciado, boolean esVerdadera){
        super(enunciado);
        if (esVerdadera){
            opcionCorrecta = new Opcion("Verdadero");
            opcionIncorrecta = new Opcion("Falso");
        }
        else {
            opcionCorrecta = new Opcion("Falso");
            opcionIncorrecta = new Opcion("Verdadero");
        }
    }

    protected Opcion getOpcionCorrecta(){ return opcionCorrecta;}

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);

}