package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceClasico extends MultipleChoice {


    public MultipleChoiceClasico(String enunciado,ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado,opcionesCorrectas,opcionesIncorrectas);
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

    public Puntaje duplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return puntaje.duplicarPuntaje(exclusividad);
    }

    public Puntaje cuadruplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return puntaje.duplicarPuntaje(exclusividad);
    }

}