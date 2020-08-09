package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalsoPenalidad extends VerdaderoFalso{

    public VerdaderoFalsoPenalidad(String enunciado, boolean esVerdadera){
        super(enunciado, esVerdadera);
    }

    public  Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        if (listaDeRespuestas.get(0).valor() == opcionCorrecta().valor()){
            Puntaje puntajePositivo = new Puntaje(1);
            return puntajePositivo;
        }
        Puntaje puntajeNegativo = new Puntaje(-1);
        return puntajeNegativo;
    }

    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador){
        return puntaje.aplicarMultiplicador(multiplicador);
    }

    public Puntaje duplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return puntaje;
    }

    public Puntaje cuadruplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return puntaje;
    }

}

