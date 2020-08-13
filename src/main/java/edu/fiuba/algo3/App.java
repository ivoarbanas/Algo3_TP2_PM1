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
        stage.setTitle("Kahoot 2");

        ContenedorNombres contenedorPrincipal = new ContenedorNombres(stage, kahoot);
        Scene escenaNombres = new Scene(contenedorPrincipal, 512, 250);

        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerNombres = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaNombres.setOnKeyPressed(aplicacionOnKeyPressEventHandlerNombres);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaNombres,kahoot);
        Scene escenaInicial = new Scene(contenedorBienvenidos, 512, 250);

        AplicacionOnKeyPressEventHandler aplicacionOnKeyPressEventHandlerInicial = new AplicacionOnKeyPressEventHandler(stage, contenedorBienvenidos.getBarraDeMenu());
        escenaInicial.setOnKeyPressed(aplicacionOnKeyPressEventHandlerInicial);

        stage.setScene(escenaInicial);
        stage.show();
    }
}