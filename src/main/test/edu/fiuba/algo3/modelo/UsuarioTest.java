package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {
    @Test
    public void elige2VecesLaMismaOpcionYNoLaAgregaALasRespuestasDelUsuario(){
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("0");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("-1");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Mas que vos");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cuantas copas tenes?");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionIncorrecta);
        Usuario jugador = new Usuario("July");
        jugador.nuevaRespuesta(opcionCorrecta1);
        jugador.nuevaRespuesta(opcionCorrecta1);

        assertEquals(1, jugador.respuestas().size());
    }
    @Test
    public void elige2OpcionesYLasAgregaALasRespuestasDelUsuario(){
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("0");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("-1");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Mas que vos");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cuantas copas tenes?");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionIncorrecta);
        Usuario jugador = new Usuario("July");
        jugador.nuevaRespuesta(opcionCorrecta1);
        jugador.nuevaRespuesta(opcionCorrecta2);

        assertEquals(2, jugador.respuestas().size());
    }
    @Test
    public void seCreaUnaNuevaRondaYSeBorranLasRespuestasAnterioresDelUsuario(){
        OpcionCorrecta opcionCorrecta1 = new OpcionCorrecta("0");
        OpcionCorrecta opcionCorrecta2 = new OpcionCorrecta("-1");
        OpcionIncorrecta opcionIncorrecta = new OpcionIncorrecta("Mas que vos");
        MultipleChoiceClasico pregunta = new MultipleChoiceClasico("Cuantas copas tenes?");
        pregunta.agregarOpcion(opcionCorrecta1);
        pregunta.agregarOpcion(opcionCorrecta2);
        pregunta.agregarOpcion(opcionIncorrecta);
        Usuario jugador = new Usuario("July");
        jugador.nuevaRespuesta(opcionCorrecta1);
        jugador.nuevaRespuesta(opcionCorrecta2);
        jugador.nuevaRonda();

        assertEquals(0, jugador.respuestas().size());
    }
}
