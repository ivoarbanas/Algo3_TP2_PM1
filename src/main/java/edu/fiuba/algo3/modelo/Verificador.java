package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Verificador {



    public Verificador(){}

    // VERIFICAR VIEJO
    public void verificar(Pregunta pregunta, Usuario jugador){
        int cantidadVerificadas = 0;
        for(int i=0; i<jugador.respuestas().size(); i++){
            cantidadVerificadas++;
            for(int j=0; j<(pregunta.opciones()).size(); j++){
                pregunta.opciones().get(j).asignacionPuntaje(jugador.respuestas().get(i), pregunta, jugador, cantidadVerificadas);
            }
        }
    }


/*
    // VERIFICAR NUEVO
    public void verificarChoice(Pregunta pregunta, Usuario jugador) {
        int cantidadCorrectas = 0;
        if (jugador.cantidadRespuestasDelUsuario() == pregunta.cantidadOpcionesCorrectas()) {
            for (int i = 0; i < jugador.cantidadRespuestasDelUsuario(); i++) {
                if (contieneOpcion(pregunta.opciones(), jugador.respuestas().get(i).valor())) {
                    cantidadCorrectas++;
                }
            }
            if (cantidadCorrectas == pregunta.cantidadOpcionesCorrectas()) {
                pregunta.respuestaEsCorrecta(jugador);
            } else {
                pregunta.respuestaEsIncorrecta(jugador);
            }
        }
    }



    public boolean contieneOpcion(ArrayList<Opcion> opciones, String valor){
        boolean contiene = false;
        for( int i=0; i < opciones.size() ; i++){
            if (opciones.get(i).valor() == valor){
                contiene = true;
            }
        }
        return contiene;
    }*/
}
