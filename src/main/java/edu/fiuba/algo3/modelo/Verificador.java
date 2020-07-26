package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Verificador {



    public Verificador(){}

    public int verificar(Pregunta pregunta, Usuario jugador){
        int puntajeParcial = 0;
        int cantidadVerificadas = 0;
        for(int i=0; i<jugador.respuestas().size(); i++){
            cantidadVerificadas++;
            for(int j=0; j<(pregunta.opciones()).size(); j++){
                //corregir encapsulamiento
                puntajeParcial += pregunta.opciones().get(j).asignacionPuntaje(jugador.respuestas().get(i), pregunta, jugador, cantidadVerificadas);
            }
        }
        return puntajeParcial;
    }

}
