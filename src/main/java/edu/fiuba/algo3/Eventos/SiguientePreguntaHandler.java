package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SiguientePreguntaHandler implements EventHandler<ActionEvent> {

    Kahoot kahoot;
    Stage stage;
    ContenedorPregunta contenedorPregunta;

    public SiguientePreguntaHandler(Kahoot kahoot, Stage stage, ContenedorPregunta contenedorPregunta){
        this.kahoot = kahoot;
        this.stage = stage;
        this.contenedorPregunta = contenedorPregunta;
    }

    @Override
    public void handle(ActionEvent event) {
        if(kahoot.finDeJuego()){
            FinDeJuegoHandler finDeJuegoHandler = new FinDeJuegoHandler(stage,kahoot);
            finDeJuegoHandler.handle(event);
        }
        else{
            kahoot.cambiarRonda();
            contenedorPregunta.mostrarPregunta();
        }
    }
}
