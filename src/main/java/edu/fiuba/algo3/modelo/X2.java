package edu.fiuba.algo3.modelo;

public class X2 extends Multiplicador {

    public Puntaje aplicarValorDelMultiplicador(Puntaje puntajeAModificar){
        puntajeAModificar.cantidad( (puntajeAModificar.valor()) * 2 );
        return puntajeAModificar;
    }
}
