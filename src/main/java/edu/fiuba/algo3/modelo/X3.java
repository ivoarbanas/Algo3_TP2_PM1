package edu.fiuba.algo3.modelo;

public class X3 extends Multiplicador {

    public Puntaje aplicarValorDelMultiplicador(Puntaje puntajeAModificar){
        puntajeAModificar.cantidad( (puntajeAModificar.valor()) * 3 );
        return puntajeAModificar;
    }
}