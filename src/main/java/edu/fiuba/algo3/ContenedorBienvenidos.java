package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorBienvenidos extends BorderPane {

    BarraDeMenu menuBar;
    Scene proximaEscena;
    Kahoot kahoot;
    Stage stage;


    public ContenedorBienvenidos(Stage stage, Scene proximaEscena, Kahoot kahoot){
        this.proximaEscena = proximaEscena;
        this.kahoot = kahoot;
        this.stage = stage;
        this.setMenu(stage);
        this.setContenido();
    }

    private void setContenido() {
        Label label = new Label("Bienvenidos a Kahoot 2");
        this.getChildren().add(label);
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/k.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(proximaEscena,stage);
        this.setTop(menuBar);

    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}