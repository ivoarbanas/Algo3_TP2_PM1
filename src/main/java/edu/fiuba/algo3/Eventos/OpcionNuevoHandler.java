package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorNombres;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpcionNuevoHandler implements EventHandler<ActionEvent> {

    Kahoot kahoot;
    Stage stage;

    public OpcionNuevoHandler(Kahoot kahoot, Stage stage){
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorNombres contenedorPrincipal = new ContenedorNombres(stage, kahoot);
        Scene escenaNombres = new Scene(contenedorPrincipal, 512, 250);
        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerNombres = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaNombres.setOnKeyPressed(aplicacionOnKeyPressEventHandlerNombres);
        stage.setScene(escenaNombres);
        stage.setFullScreen(true);

    }
}
