package edu.fiuba.algo3.modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MultipleChoicePenalidad extends MultipleChoice {

    public MultipleChoicePenalidad(String enunciado, ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado,opcionesCorrectas,opcionesIncorrectas);
        bonificable = true;
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {

        int balanceCorrectas = 0;
        for(Opcion unaOpcion : listaDeRespuestas){
            if(esIncorrecta(unaOpcion)){
                balanceCorrectas--;
            }
            else balanceCorrectas++;
        }
        Puntaje puntaje = new Puntaje();
        puntaje.cantidad(balanceCorrectas);

        return puntaje;
    }

}