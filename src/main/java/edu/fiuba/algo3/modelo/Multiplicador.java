package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract public class Multiplicador {

    protected boolean fueUsado;

    public Multiplicador(){
        fueUsado = false;
    }
    public abstract Puntaje calcularPuntajeConMultiplicador(Puntaje puntajeAMultiplicar);
    public void usar(){
        fueUsado = true;
    }

}
