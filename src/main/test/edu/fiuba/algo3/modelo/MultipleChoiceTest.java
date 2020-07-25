package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleChoiceTest {

    @Test
    public void seCreaPreguntaMultipleChoiceClasicoIndicandoRespuestaCorrecta() {
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Ocho");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Dieciseis");
        OpcionCorrecta opcionCorrecta3 = new OpcionCorrecta("Seis");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcionCorrecta("Ocho");
        pregunta.agregarOpcionCorrecta("Dieciseis");
        pregunta.agregarOpcionCorrecta("Seis");
        pregunta.agregarOpcionIncorrecta("Uno");


        assertEquals(opcionCorrecta1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionCorrecta2.valor(),pregunta.opciones().get(1).valor());
        assertEquals(opcionCorrecta3.valor(),pregunta.opciones().get(2).valor());
    }


    @Test
    public void seCreaPreguntaMultipleChoiceParcialIndicandoRespuestaCorrecta() {
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("Diecinueve");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("Tres mil");
        MultipleChoiceParcial pregunta = new MultipleChoiceParcial("Que numero es mayor a cinco");
        pregunta.agregarOpcionCorrecta("Diecinueve");
        pregunta.agregarOpcionCorrecta("Tres mil");
        pregunta.agregarOpcionIncorrecta("Uno");


        assertEquals(opcionCorrecta1.valor(),pregunta.opciones().get(0).valor());
        assertEquals(opcionCorrecta2.valor(),pregunta.opciones().get(1).valor());
    }


    @Test
    public void recibeUnaListaDeRespuestasEnMultipleChoiceClasicoYAsignaPuntosCorrectamente() {
        Usuario jugador1 = new Usuario("Manuel");
        Usuario jugador2 = new Usuario("Luciano");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Que numero es mayor a cinco");
        pregunta.agregarOpcionCorrecta("Ocho");
        pregunta.agregarOpcionCorrecta("Dieciseis");
        pregunta.agregarOpcionCorrecta("Seis");
        pregunta.agregarOpcionIncorrecta("Uno");
        //metodo de K! que habla con sus usuarios para limpiar sus respuestas anteriores
        jugador1.vaciarRespuestas();
        jugador2.vaciarRespuestas();
        //
        jugador1.elegirRespuesta(pregunta);// 0
        jugador1.elegirRespuesta(pregunta);// 1
        jugador1.elegirRespuesta(pregunta);// 2
        jugador1.elegirRespuesta(pregunta);// 3
        Verificador verificador = new Verificador();
        verificador.verificar(pregunta, jugador1);
        assertEquals(jugador1.puntos().valor(), 0);
    }

}
