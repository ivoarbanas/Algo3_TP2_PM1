package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceParcial extends MultipleChoice {


    public MultipleChoiceParcial(String enunciado, ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado,opcionesCorrectas,opcionesIncorrectas);
        bonificable = false;
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        int cantidadCorrectas = 0;

        for(int i=0;i<listaDeRespuestas.size();i++){
            if(es_incorrecta(listaDeRespuestas.get(i))){
                Puntaje puntajeNulo = new PuntajeNulo();
                return puntajeNulo;
            }
            else { cantidadCorrectas++; }
        }
        Puntaje puntajePositivo = new PuntajePositivo(cantidadCorrectas);
        return puntajePositivo;
    }

}