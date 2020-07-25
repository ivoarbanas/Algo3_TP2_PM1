package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class Pregunta {

    protected String enunciado;
    protected ArrayList <Opcion> opciones;
    protected int cantidadOpcionesValidas;

    public Pregunta(String enunciado){
        this.enunciado = enunciado;
        opciones = new ArrayList<>();
    }

    public ArrayList<Opcion> opciones() {
        return opciones;
    }
    public abstract void respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas);
    public abstract void respuestaEsIncorrecta(Usuario jugador);

    public int cantidadOpcionesCorrectas(){
        return (cantidadOpcionesValidas);
    }


    // CAPAZ SOLO ES NECESARIO PARA MULTIPLE CHOICE
}
