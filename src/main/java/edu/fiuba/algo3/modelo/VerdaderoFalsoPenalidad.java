package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalsoPenalidad extends VerdaderoFalso{

    public VerdaderoFalsoPenalidad(String enunciado, boolean esVerdadera){
        super(enunciado, esVerdadera);
    }

    public  Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        if (listaDeRespuestas.get(0).valor() == opcionCorrecta.valor()){
            Puntaje puntajePositivo = new PuntajePositivo();
            return puntajePositivo;
        }
        Puntaje puntajeNegativo = new PuntajeNegativo();
        return puntajeNegativo;
    }

}

