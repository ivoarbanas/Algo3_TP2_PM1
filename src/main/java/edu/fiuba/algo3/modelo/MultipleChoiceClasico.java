package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceClasico extends MultipleChoice {


    public MultipleChoiceClasico(String enunciado){
        super(enunciado);
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        if(!(listaDeRespuestas.size() == listaOpcionesCorrectas.size())){
            Puntaje puntajeNulo = new Puntaje(0);
            return puntajeNulo;
        }
        for (Opcion opcion: listaDeRespuestas){
            if(esIncorrecta(opcion)) {
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

    public Puntaje calcularPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return exclusividad.aplicarExclusividad(puntaje);
    }


}