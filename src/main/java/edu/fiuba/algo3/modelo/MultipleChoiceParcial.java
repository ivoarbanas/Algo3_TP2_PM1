package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceParcial extends MultipleChoice {


    public MultipleChoiceParcial(String enunciado, ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado,opcionesCorrectas,opcionesIncorrectas);
        bonificable = false;
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        int cantidadCorrectas = 0;

        for(Opcion unaOpcion : listaDeRespuestas){
            if(esIncorrecta(unaOpcion)){
                Puntaje puntajeNulo = new PuntajeNulo();
                return puntajeNulo;
            }
            else { cantidadCorrectas++; }
        }
        Puntaje puntajePositivo = new PuntajePositivo(cantidadCorrectas);
        return puntajePositivo;
    }

}