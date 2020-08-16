package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class MultipleChoice extends Pregunta {

    protected ArrayList<Opcion> listaOpcionesCorrectas;
    protected ArrayList<Opcion> listaOpcionesIncorrectas;

    public MultipleChoice(String enunciado){
        super(enunciado);
        listaOpcionesCorrectas = new ArrayList<>();
        listaOpcionesIncorrectas = new ArrayList<>();
    }

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);

    public boolean esIncorrecta(Opcion opcion){
        for (Opcion unaOpcion : listaOpcionesIncorrectas){
            if(unaOpcion.valor().equals(opcion.valor())) return true;
        }
        return false;
    }

    public void cargarOpcionCorrecta(Opcion opcion){
        listaOpcionesCorrectas.add(opcion);
        opciones.add(opcion);
    }

    public void cargarOpcionIncorrecta(Opcion opcion){
        listaOpcionesIncorrectas.add(opcion);
        opciones.add(opcion);
    }

    public abstract Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador);
    public abstract Puntaje calcularPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad);
    public ArrayList<Opcion> opcionCorrecta() {
        return listaOpcionesCorrectas;
    }
}