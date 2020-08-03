package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class MultipleChoice extends Pregunta {

    protected ArrayList<Opcion> listaOpcionesCorrectas;
    protected ArrayList<Opcion> listaOpcionesIncorrectas;

    public MultipleChoice(String enunciado, ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado);
        listaOpcionesCorrectas = opcionesCorrectas;
        listaOpcionesIncorrectas = opcionesIncorrectas;
    }

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);

    public boolean es_incorrecta(Opcion opcion){
        for (int i = 0; i<listaOpcionesIncorrectas.size(); i++){
            if(listaOpcionesIncorrectas.get(i).valor().equals(opcion.valor())) return true;
        }
        return false;
    }
}