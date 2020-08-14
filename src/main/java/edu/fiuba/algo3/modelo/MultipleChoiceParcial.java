package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceParcial extends MultipleChoice {


    public MultipleChoiceParcial(String enunciado){
        super(enunciado);
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        int cantidadCorrectas = 0;

        for(Opcion unaOpcion : listaDeRespuestas){
            if(esIncorrecta(unaOpcion)){
                Puntaje puntajeNulo = new Puntaje(0);
                return puntajeNulo;
            }
            else { cantidadCorrectas++; }
        }
        Puntaje puntajePositivo = new Puntaje(cantidadCorrectas);
        return puntajePositivo;
    }

    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador){
        return puntaje;
    }

    public Puntaje calcularPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        if(puntaje.valor() == listaOpcionesCorrectas.size()){
            return exclusividad.aplicarExclusividad(puntaje);
        }
            return puntaje;


    }

}