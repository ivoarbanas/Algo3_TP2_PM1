package edu.fiuba.algo3.modelo;

public class Puntaje {
    private int valor;

    public Puntaje(){
        valor = 0;
    }
    public Puntaje(int valor){
        this.valor = valor;
    }
    public void cantidad(int cantidad){
        valor = cantidad;
    }
    public int valor(){
        return valor;
    }

    public Puntaje aplicarMultiplicador(Multiplicador multiplicador) {
        this.cantidad( (this.valor()) *  multiplicador.valorDelMultiplicador() );
        return this;
    }

    public Puntaje duplicarPuntaje(ExclusividadDePuntaje exclusividad) {
        valor = valor * exclusividad.valorDeLaExclusividad();
        return this;
    }

    public Puntaje cuadriplicarPuntaje(ExclusividadDePuntaje exclusividad) {
        valor = valor * (exclusividad.valorDeLaExclusividad() * exclusividad.valorDeLaExclusividad()) ;
        return this;
    }
}
