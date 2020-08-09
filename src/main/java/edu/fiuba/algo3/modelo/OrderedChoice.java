package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta {


    public OrderedChoice(String enunciado, ArrayList<Opcion> opcionesOrdenadas){
        super(enunciado);
        opciones = opcionesOrdenadas;
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas){
        for (int i=0; i < listaDeRespuestas.size();i++){
            if(!opciones.get(i).valor().equals(listaDeRespuestas.get(i).valor())){
                Puntaje puntajeNulo = new Puntaje(0);
                return puntajeNulo;
            }
        }
        Puntaje puntajePositivo = new Puntaje(1);
        return puntajePositivo;
    }

    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador){
        return puntaje;
    }

    public Puntaje duplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return puntaje.duplicarPuntaje(exclusividad);
    }

    public Puntaje cuadruplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return puntaje.duplicarPuntaje(exclusividad);
    }

}
