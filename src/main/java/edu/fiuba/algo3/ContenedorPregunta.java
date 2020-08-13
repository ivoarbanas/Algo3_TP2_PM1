package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPregunta extends BorderPane {

    BarraDeMenu menuBar;
    Kahoot kahoot;
    Stage stage;

    public ContenedorPregunta(Stage stage, Kahoot kahoot){
        this.stage = stage;
        this.kahoot = kahoot;
        this.setMenu(stage);
        this.setContenido();
    }

    private void setContenido() {

    }

    private void setMenu(Stage stage) {
        Scene vacia = new Scene(new VBox());
        this.menuBar = new BarraDeMenu(vacia,stage);
        this.setTop(menuBar);

    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}
