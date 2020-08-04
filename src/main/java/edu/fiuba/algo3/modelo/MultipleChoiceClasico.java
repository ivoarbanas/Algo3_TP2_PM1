package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceClasico extends MultipleChoice {


    public MultipleChoiceClasico(String enunciado,ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado,opcionesCorrectas,opcionesIncorrectas);
        bonificable = false;
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        if(!(listaDeRespuestas.size() == listaOpcionesCorrectas.size())){
            Puntaje puntajeNulo = new PuntajeNulo();
            return puntajeNulo;
        }
        for (int i=0;i<listaDeRespuestas.size();i++){
            if(es_incorrecta(listaDeRespuestas.get(i))) {
                Puntaje puntajeNulo = new PuntajeNulo();
                return puntajeNulo;
            }
        }
        Puntaje puntajePositivo = new PuntajePositivo();
        return puntajePositivo;
    }

}