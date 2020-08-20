package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.AplicacionOnKeyPressEventHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * JavaFX App
 */
public class App extends Application  {

    public static void main(String[] args) {
        launch(); //llama a start
    }

    @Override
    public void start(Stage stage) {
        Kahoot kahoot = new Kahoot();
        kahoot.cargarPreguntas();
        stage.setTitle("Kahoot 2");
        stage.setFullScreen(true);

        String musicFile = "kahoot.mp3";

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();

        ContenedorNombres contenedorNombres = new ContenedorNombres(stage, kahoot,mediaPlayer);
        Scene escenaInicial = new Scene(contenedorNombres, 1024, 500);

        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerInicial = new AplicacionOnKeyPressEventHandler(stage, contenedorNombres.getBarraDeMenu());
        escenaInicial.setOnKeyPressed(aplicacionOnKeyPressEventHandlerInicial);

        stage.setScene(escenaInicial);
        stage.show();
    }
}