package edu.fiuba.algo3.modelo;

public class ExclusividadDePuntajeDoble extends ExclusividadDePuntaje {

    public Puntaje aplicarExclusividad(Puntaje puntaje) {
        puntaje.cantidad(puntaje.valor() * 2);
        return puntaje;
    }


}
