package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class MultipleChoiceClasico extends MultipleChoice {


    public MultipleChoiceClasico(String enunciado,ArrayList<Opcion> opcionesCorrectas, ArrayList<Opcion> opcionesIncorrectas){
        super(enunciado,opcionesCorrectas,opcionesIncorrectas);
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        if(!(listaDeRespuestas.size() == listaOpcionesCorrectas.size())){
            Puntaje puntajeNulo = new PuntajeNulo();
            return puntajeNulo;
        }
        for (Opcion opcion: listaDeRespuestas){
            if(esIncorrecta(opcion)) {
                Puntaje puntajeNulo = new PuntajeNulo();
                return puntajeNulo;
            }
        }
        Puntaje puntajePositivo = new PuntajePositivo();
        return puntajePositivo;
    }
    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador){
        return puntaje.aplicarMultiplicador(multiplicador);
    }

}