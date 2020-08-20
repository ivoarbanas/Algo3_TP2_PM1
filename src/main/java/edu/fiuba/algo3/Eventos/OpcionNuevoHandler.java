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
        ContenedorNombres contenedorPrincipal = new ContenedorNombres(stage, kahoot,mediaPlayer);
        Scene escenaNombres = new Scene(contenedorPrincipal, 1024, 500);

        /*escenaNombres.getStylesheets().add("style.css");
        escenaNombres.getStylesheets().add("https://fonts.googleapis.com/css2?family=Viga&display=swap");*/


        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerNombres = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaNombres.setOnKeyPressed(aplicacionOnKeyPressEventHandlerNombres);
        stage.setScene(escenaNombres);
        stage.setFullScreen(true);

    }
}
