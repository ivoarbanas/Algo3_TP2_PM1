package edu.fiuba.algo3.modelo;

public class Verificador {

    public Verificador(){}

    public void verificar(Pregunta pregunta, Usuario jugador){
        for(int i=0; i<jugador.respuestas().size(); i++){
            for(int j=0; j<(pregunta.opcionesCorrectas()).size(); j++){
                if(jugador.respuestas().get(i).valor().equals(pregunta.opcionesCorrectas().get(j).valor())){
                    pregunta.respuestaEsCorrecta(jugador);
                }
                else{
                    pregunta.respuestaEsIncorrecta(jugador);
                }
            }
        }
    }
}