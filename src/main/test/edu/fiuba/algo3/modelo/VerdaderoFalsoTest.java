package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void seCreaPreguntaVerdaderoFalsoIndicandoRespuestaCorrecta(){

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Falso");
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial",opcionCorrecta,opcionIncorrecta);
        assertEquals(opcionCorrecta.valor(), pregunta.obtenerOpcionCorrecta().valor());

    }

    @Test
    public void recibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

    }

}
