package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta {

    public ArrayList<Opcion> listaOrdenada;

    public OrderedChoice(String enunciado, ArrayList<Opcion> opcionesOrdenadas){
        super(enunciado);
        listaOrdenada = opcionesOrdenadas;
        bonificable = false;
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas){
        for (int i=0; i < listaDeRespuestas.size();i++){
            if(!listaOrdenada.get(i).valor().equals(listaDeRespuestas.get(i).valor())){
                Puntaje puntajeNulo = new PuntajeNulo();
                return puntajeNulo;
            }
        }
        Puntaje puntajePositivo = new PuntajePositivo();
        return puntajePositivo;
    }

}
