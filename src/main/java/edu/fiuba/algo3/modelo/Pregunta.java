package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class Pregunta {

    protected String enunciado;
    protected ArrayList <OpcionCorrecta> opcionesCorrectas;
    protected ArrayList <OpcionIncorrecta> opcionesIncorrectas;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opcionesCorrectas = new ArrayList<>();
        opcionesIncorrectas = new ArrayList<>();
    }

    public ArrayList<OpcionCorrecta> opcionesCorrectas() {
        return opcionesCorrectas;
    }
    public abstract void respuestaEsCorrecta(Usuario jugador);
    public abstract void respuestaEsIncorrecta(Usuario jugador);

    public int cantidadOpcionesCorrectas(){
        return (opcionesCorrectas.size());
    }

    public int cantidadOpcionesIncorrectas(){ return (opcionesIncorrectas.size()); }

    // CAPAZ SOLO ES NECESARIO PARA MULTIPLE CHOICE
}
