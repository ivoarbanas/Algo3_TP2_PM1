package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorNombres;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class OpcionNuevoHandler implements EventHandler<ActionEvent> {

    Kahoot kahoot;
    Stage stage;
    MediaPlayer mediaPlayer;

    public OpcionNuevoHandler(Kahoot kahoot, Stage stage, MediaPlayer mediaPlayer){
        this.kahoot = kahoot;
        this.stage = stage;
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        ReiniciarHandler reiniciarHandler = new ReiniciarHandler(stage);
        reiniciarHandler.handle(actionEvent);


    }
}
