package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrderedChoice extends Pregunta {


    public OrderedChoice(String enunciado){
        super(enunciado);
    }

    public Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas){
        for (int i=0; i < listaDeRespuestas.size();i++){
            if(!opciones.get(i).valor().equals(listaDeRespuestas.get(i).valor())){
                Puntaje puntajeNulo = new Puntaje(0);
                return puntajeNulo;
            }
        }
        Puntaje puntajePositivo = new Puntaje(1);
        return puntajePositivo;
    }

    public Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador){
        return puntaje;
    }

    public Puntaje calcularPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad){
        return exclusividad.aplicarExclusividad(puntaje);
    }

    public void cargarOpcionOrdenada(Opcion opcion){
        opciones.add(opcion);
    }

    public ArrayList<Opcion> opcionCorrecta() {
        return null;
    }
}
