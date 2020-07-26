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
    public abstract int respuestaEsCorrecta(Usuario jugador, int respuestasVerificadas);
    public abstract int respuestaEsIncorrecta(Usuario jugador, int respuestasVerificadas);

    public int verificar(Usuario jugador, int cantidadVerificadas, int opcion) {
        return opciones().get(opcion).verificar(jugador.respuestas().get(cantidadVerificadas-1), this, jugador, cantidadVerificadas);
    }

    public void agregarOpcion(Opcion opcion) {
        opciones.add(opcion);
    }


    // CAPAZ SOLO ES NECESARIO PARA MULTIPLE CHOICE
}
