package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerdaderoFalsoTest {
    @Test
    public void seCreaPreguntaVerdaderoFalsoIndicandoRespuestaCorrecta(){

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Falso");
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial","Verdadero","Falso");
        assertEquals(opcionCorrecta.valor(), pregunta.opcionesCorrectas().get(0).valor());
    }

    @Test
    public void recibeUnaListaDeRespuestasYAsignaCorrectamentePuntosALosJugadoresQueRespondieronCorrectamente(){

        Usuario jugador1 = new Usuario("Jorge");
        Usuario jugador2 = new Usuario("Ramiro");
        VerdaderoFalsoClasico pregunta = new VerdaderoFalsoClasico("Aprobé el parcial","Verdadero","Falso");
        //metodo de K! que habla con sus usuarios para limpiar sus respuestas anteriores
        jugador1.vaciarRespuestas();
        jugador2.vaciarRespuestas();
        //
        jugador1.nuevaRespuesta("Verdadero");
        jugador2.nuevaRespuesta("Falso");
        Verificador verificador = new Verificador();
        verificador.verificar(pregunta, jugador1);
        verificador.verificar(pregunta, jugador2);

        assertEquals(jugador1.puntos().valor(), 1);
        assertEquals(jugador2.puntos().valor(), 0);
    }

    @Test
    public void recibeUnaListaDeRespuestasEnVerdaderoFalsoPenalidadYAsignaPuntosCorrectamente(){

        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial","Verdadero","Falso");
        //metodo de K! que habla con sus usuarios para limpiar sus respuestas anteriores
        jugador1.vaciarRespuestas();
        jugador2.vaciarRespuestas();
        //
        jugador1.nuevaRespuesta("Falso");
        jugador2.nuevaRespuesta("Verdadero");
        Verificador verificador = new Verificador();
        verificador.verificar(pregunta, jugador1);
        verificador.verificar(pregunta, jugador2);

        assertEquals(jugador1.puntos().valor(), -1);
        assertEquals(jugador2.puntos().valor(), 1);
    }

    @Test
    public void seCreaPreguntaVerdaderoFalsoPenalidadIndicandoRespuestaCorrecta(){

        OpcionCorrecta opcionCorrecta = new OpcionCorrecta("Verdadero");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Falso");
        VerdaderoFalsoPenalidad pregunta = new VerdaderoFalsoPenalidad("Aprobé el parcial","Verdadero","Falso");
        assertEquals(opcionCorrecta.valor(), pregunta.opcionesCorrectas().get(0).valor());
    }


}
