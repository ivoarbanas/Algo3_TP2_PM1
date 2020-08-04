package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class VerdaderoFalso extends Pregunta {

    boolean esVerdadera;
    Opcion opcionCorrecta;

    public VerdaderoFalso(String enunciado, boolean esVerdadera){
        super(enunciado);
        if (esVerdadera){
            esVerdadera = true;
            opcionCorrecta = new Opcion("Verdadero");
        }
        else {
            esVerdadera = false;
            opcionCorrecta = new Opcion("Falso");
        }
    }

    protected Opcion getOpcionCorrecta(){ return opcionCorrecta;}

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);

}