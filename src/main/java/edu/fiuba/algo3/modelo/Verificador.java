package edu.fiuba.algo3.modelo;

public class Verificador {

    public Verificador(){}

    public void verificar(Pregunta pregunta, Usuario jugador){
        for(int i=0; i<jugador.respuestas().size(); i++){
            for(int j=0; j<(pregunta.opciones()).size(); j++){
                pregunta.opciones().get(j).asignacionPuntaje(jugador.respuestas().get(i), pregunta, jugador);
            }
        }
    }
}
