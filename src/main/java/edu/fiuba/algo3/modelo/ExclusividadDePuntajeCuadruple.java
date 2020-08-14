package edu.fiuba.algo3.modelo;

public class ExclusividadDePuntajeCuadruple extends ExclusividadDePuntaje{
    public Puntaje aplicarExclusividad(Puntaje puntaje) {
        puntaje.cantidad(puntaje.valor() * 4);
        return puntaje;
    }
}
