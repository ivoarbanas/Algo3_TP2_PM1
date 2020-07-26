package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Verificador {



    public Verificador(){}

    public int verificar(Pregunta pregunta, Usuario jugador){
        int puntajeParcial = 0;
        for(int i=0; i<jugador.respuestas().size(); i++){
            for(int j=0; j<(pregunta.opciones()).size(); j++){
                puntajeParcial += pregunta.verificar(jugador, i+1, j);
            }
        }
        return puntajeParcial;
    }

}
