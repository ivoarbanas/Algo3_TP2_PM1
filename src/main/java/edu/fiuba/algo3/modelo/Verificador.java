package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Verificador {

    public Verificador(){}

    // VERIFICAR VIEJO
    /*public void verificar(Pregunta pregunta, Usuario jugador){
        for(int i=0; i<jugador.respuestas().size(); i++){
            for(int j=0; j<(pregunta.opciones()).size(); j++){
                pregunta.opciones().get(j).asignacionPuntaje(jugador.respuestas().get(i), pregunta, jugador);
            }
        }
    }*/

    // VERIFICAR NUEVO
    public void verificar(Pregunta pregunta, Usuario jugador) {
        int cantidadCorrectas = 0;
        if (jugador.cantidadRespuestasDelUsuario() == pregunta.cantidadOpcionesCorrectas()) {
            for (int i = 0; i < jugador.cantidadRespuestasDelUsuario(); i++) {
                if (contieneOpcion(pregunta.opcionesCorrectas(), jugador.respuestas().get(i).valor())) {
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



    public boolean contieneOpcion(ArrayList<OpcionCorrecta> opcionesCorrectas, String valor){
        boolean contiene = false;
        for( int i=0; i < opcionesCorrectas.size() ; i++){
            if (opcionesCorrectas.get(i).valor() == valor){
                contiene = true;
            }
        }
        return contiene;
    }
}
