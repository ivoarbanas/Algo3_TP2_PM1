package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class Pregunta {

    protected String enunciado;
    protected boolean bonificable;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
    }

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);

    public boolean esBonificable(){
        return bonificable;
    }


}
