package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalsoClasico extends VerdaderoFalso{

    public VerdaderoFalsoClasico(String enunciado, boolean esVerdadera){
        super(enunciado, esVerdadera);
    }

    public  Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        if (listaDeRespuestas.get(0).valor().equals(opcionCorrecta.valor())){
            Puntaje puntajePositivo = new PuntajePositivo();
            return puntajePositivo;
        }
        Puntaje puntajeNulo = new PuntajeNulo();
        return puntajeNulo;
    }
}
