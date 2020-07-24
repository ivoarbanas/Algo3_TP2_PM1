package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class Pregunta {

    protected String enunciado;
    protected ArrayList <Opcion> opciones;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opciones = new ArrayList<>();
    }

    public ArrayList<Opcion> opciones() {
        return opciones;
    }
    public abstract void respuestaEsCorrecta(Usuario jugador);
    public abstract void respuestaEsIncorrecta(Usuario jugador);
}
