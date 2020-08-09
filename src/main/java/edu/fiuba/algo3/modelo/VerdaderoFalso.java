package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class VerdaderoFalso extends Pregunta {

    private Opcion opcionCorrecta;
    private Opcion opcionIncorrecta;

    public VerdaderoFalso(String enunciado, boolean esVerdadera){
        super(enunciado);
        Opcion opcionVerdadero = new Opcion("Verdadero");
        Opcion opcionFalso = new Opcion("Falso");
        if (esVerdadera){
            opcionCorrecta = opcionVerdadero;
            opcionIncorrecta = opcionFalso;
        }
        else {
            opcionCorrecta = opcionFalso;
            opcionIncorrecta = opcionVerdadero;
        }
        opciones = new ArrayList<Opcion>();
        opciones.add(opcionVerdadero);
        opciones.add(opcionFalso);
    }

    public Opcion opcionCorrecta(){ return opcionCorrecta;}

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);
    public abstract Puntaje calcularPuntajeConMultiplicador(Puntaje puntaje, Multiplicador multiplicador);
    public abstract Puntaje duplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad);
    public abstract Puntaje cuadruplicarPuntajeConExclusividad(Puntaje puntaje, ExclusividadDePuntaje exclusividad);

}