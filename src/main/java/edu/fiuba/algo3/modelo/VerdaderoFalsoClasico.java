package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalsoClasico extends VerdaderoFalso{

    public VerdaderoFalsoClasico(String enunciado, boolean esVerdadera){
        super(enunciado, esVerdadera);
    }

    public  Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas) {
        if (listaDeRespuestas.get(0).valor().equals(opcionCorrecta().valor())){
            Puntaje puntajePositivo = new Puntaje(1);
            return puntajePositivo;
        }
        Puntaje puntajeNulo = new Puntaje(0);
        return puntajeNulo;
    }

    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador){
        return puntaje;
    }

    public Puntaje calcularPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return exclusividad.aplicarExclusividad(puntaje);
    }

}
