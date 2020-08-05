package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class Pregunta {

    protected String enunciado;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
    }

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);
    public abstract Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador);
    


}
