package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class VerdaderoFalso extends Pregunta {

    boolean es_verdadera;
    Opcion opcionCorrecta;

    public VerdaderoFalso(String enunciado, boolean esVerdadera){
        super(enunciado);
        if (esVerdadera){
            es_verdadera = true;
            opcionCorrecta = new Opcion("Verdadero");
        }
        else {
            es_verdadera = false;
            opcionCorrecta = new Opcion("Falso");
        }
    }

    public Opcion getOpcionCorrecta(){ return opcionCorrecta;}

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);

}