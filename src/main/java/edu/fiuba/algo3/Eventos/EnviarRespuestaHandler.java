package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EnviarRespuestaHandler implements EventHandler<ActionEvent> {

    Kahoot kahoot;
    ToggleGroup grupoMultiplicadores;
    ArrayList<ToggleButton> botonesMultiplicadores;
    Pregunta pregunta;
    ContenedorPregunta contenedor;
    Stage stage;

    public EnviarRespuestaHandler(Kahoot kahoot, Stage stage, ToggleGroup grupoMultiplicadores, ArrayList<ToggleButton> botonesMultiplicadores, Pregunta pregunta,  ContenedorPregunta contenedor){
        this.kahoot = kahoot;
        this.grupoMultiplicadores = grupoMultiplicadores;
        this.botonesMultiplicadores = botonesMultiplicadores;
        this.pregunta = pregunta;
        this.contenedor = contenedor;
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent event) {
        Toggle multiplicadoresTogger = grupoMultiplicadores.getSelectedToggle();
        if(multiplicadoresTogger == botonesMultiplicadores.get(0)){
            contenedor.getJugadorActivo().utilizarMultiplicadorX2();
            botonesMultiplicadores.get(0).setSelected(false);
        }
        else if(multiplicadoresTogger == botonesMultiplicadores.get(1)){
            contenedor.getJugadorActivo().utilizarMultiplicadorX3();
            botonesMultiplicadores.get(1).setSelected(false);
        }
        else if(multiplicadoresTogger == botonesMultiplicadores.get(2)){
            contenedor.getJugadorActivo().utilizarExclusividadPuntaje();
        }
        if(contenedor.getJugadorActivo() == kahoot.jugadores().get(1)){
            contenedor.jugadorActivo(kahoot.jugadores().get(0));
            kahoot.verificarRonda();
            kahoot.cambiarRonda();
            MostrarResultadoHandler mostrarResultadoHandler = new MostrarResultadoHandler(pregunta.opcionCorrecta(),contenedor,kahoot,stage);
            mostrarResultadoHandler.handle(event);
        }
        else{
            contenedor.jugadorActivo(kahoot.jugadores().get(1));
        }
    }
}
