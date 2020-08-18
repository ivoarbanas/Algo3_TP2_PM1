package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.AplicacionOnKeyPressEventHandler;
import edu.fiuba.algo3.modelo.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, kahoot);
        Scene escenaInicial = new Scene(contenedorBienvenidos, 512, 250);

        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerInicial = new AplicacionOnKeyPressEventHandler(stage, contenedorBienvenidos.getBarraDeMenu());
        escenaInicial.setOnKeyPressed(aplicacionOnKeyPressEventHandlerInicial);

        stage.setScene(escenaInicial);
        stage.show();
    }
}