package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorNombres;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class ReiniciarHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public ReiniciarHandler(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        Kahoot kahoot = new Kahoot();
        kahoot.cargarPreguntas();
        stage.setTitle("Kahoot 2");
        stage.setFullScreen(true);
        String musicFile = "kahoot.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
        ContenedorNombres contenedorPrincipal = new ContenedorNombres(stage, kahoot,mediaPlayer);
        Scene escenaNombres = new Scene(contenedorPrincipal, 512, 250);
        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerNombres = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaNombres.setOnKeyPressed(aplicacionOnKeyPressEventHandlerNombres);
        stage.setScene(escenaNombres);
        stage.setFullScreen(true);
    }
}
