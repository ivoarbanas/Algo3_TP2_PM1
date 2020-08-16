package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Pregunta {

    protected String enunciado;
    protected ArrayList<Opcion> opciones;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opciones = new ArrayList<>();
    }

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);
    public abstract Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador);
    public abstract Puntaje calcularPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad);
    public ArrayList<Opcion> obtenerOpciones(){
        return opciones;
    }
    public String enunciado(){
        return enunciado;
    }
    public ArrayList<Opcion> opciones(){
        return opciones;
    }

    public abstract ArrayList<Opcion> opcionCorrecta();
}
