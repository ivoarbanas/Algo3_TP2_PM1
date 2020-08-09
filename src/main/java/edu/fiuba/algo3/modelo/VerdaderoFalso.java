package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

abstract class VerdaderoFalso extends Pregunta {

    Opcion opcionCorrecta;
    Opcion opcionIncorrecta;

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

    public Opcion getOpcionCorrecta(){ return opcionCorrecta;}

    public abstract Puntaje calcularPuntajeParaRespuesta(ArrayList<Opcion> listaDeRespuestas);

}