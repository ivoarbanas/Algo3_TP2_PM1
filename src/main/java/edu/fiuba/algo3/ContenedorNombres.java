package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.CargarUsuarioHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorNombres extends BorderPane {
    BarraDeMenu menuBar;
    Kahoot kahoot;
    Stage stage;


    public ContenedorNombres(Stage stage, Kahoot kahoot){
        this.kahoot = kahoot;
        this.stage = stage;
        this.setMenu(stage);
        this.setContenido();
    }


    private void setContenido() {

        HBox cajaJugadorUno = new HBox();
        HBox cajaJugadorDos = new HBox();
        VBox cajaY = new VBox();
        Label labelJugadorUno = new Label("Ingrese nombre de jugador 1: ");
        TextField cajaNombreJugadorUno = new TextField();
        cajaJugadorUno.getChildren().addAll(labelJugadorUno,cajaNombreJugadorUno);
        Label labelJugadorDos = new Label("Ingrese nombre de jugador 2: ");
        TextField cajaNombreJugadorDos = new TextField();
        cajaJugadorDos.getChildren().addAll(labelJugadorDos,cajaNombreJugadorDos);
        Button cargarJugadores = new Button("Empezar");
        cajaY.getChildren().addAll(cajaJugadorUno,cajaJugadorDos,cargarJugadores);
        CargarUsuarioHandler cargarUsuarioHandler = new CargarUsuarioHandler(kahoot,cajaNombreJugadorUno,cajaNombreJugadorDos,stage);
        cargarJugadores.setOnAction(cargarUsuarioHandler);
        this.setCenter(cajaY);

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