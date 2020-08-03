package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultipleChoicePenalidad extends MultipleChoice {

    public MultipleChoicePenalidad(String enunciado, ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado,opcionesCorrectas,opcionesIncorrectas);
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {

        int balanceCorrectas = 0;
        for(int i=0;i<listaDeRespuestas.size();i++){
            if(es_incorrecta(listaDeRespuestas.get(i))){
                balanceCorrectas--;
            }
            else balanceCorrectas++;
        }
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(balanceCorrectas);
        return puntaje;
    }

}