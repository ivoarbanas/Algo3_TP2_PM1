package edu.fiuba.algo3.modelo;

public class X3 extends Multiplicador {

    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntajeAMultiplicar) {

        puntajeAMultiplicar.cantidad((puntajeAMultiplicar.valor()) * 3);
        return puntajeAMultiplicar;

    }
}
