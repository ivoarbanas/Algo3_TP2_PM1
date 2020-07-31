package edu.fiuba.algo3.modelo;

public class Verificador {



    public Verificador(){}

    public Puntaje verificar(Pregunta pregunta, Usuario jugador){
        Puntaje puntajeParcial = new Puntaje();
        puntajeParcial.cantidad(0);
        for(int i=0; i<jugador.respuestas().size(); i++){
            for(int j=0; j<(pregunta.opciones()).size(); j++){
                puntajeParcial.cantidad(puntajeParcial.valor()+pregunta.verificar(jugador, i+1, j).valor());
            }
        }
        return puntajeParcial;
    }

}
