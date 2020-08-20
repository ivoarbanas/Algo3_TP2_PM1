package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.CargarUsuarioHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorNombres extends BorderPane {
    BarraDeMenu menuBar;
    Kahoot kahoot;
    Stage stage;
    MediaPlayer mediaPlayer;


    public ContenedorNombres(Stage stage, Kahoot kahoot, MediaPlayer mediaPlayer){
        this.kahoot = kahoot;
        this.stage = stage;
        this.mediaPlayer = mediaPlayer;
        this.setMenu(stage);
        this.setContenido();
    }


    private void setContenido() {

        Image fondo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        ImageView aux = new ImageView("file:src/main/java/edu/fiuba/algo3/imagenes/logo_purple.png");
        HBox imagen = new HBox();
        imagen.getChildren().add(aux);
        imagen.setPrefSize(200,50);
        HBox cajaJugadorUno = new HBox();
        HBox cajaJugadorDos = new HBox();
        VBox cajaY = new VBox();
        //Label labelJugadorUno = new Label("Ingrese nombre de jugador 1: ");
        //labelJugadorUno.getStyleClass().add("nombre");
        TextField cajaNombreJugadorUno = new TextField();
        cajaNombreJugadorUno.setFont(Font.font("Verdana", FontWeight.BOLD, 70));
        cajaNombreJugadorUno.setFocusTraversable(false);
        //cajaNombreJugadorUno.setAlignment(Pos.CENTER);
        cajaNombreJugadorUno.setPromptText("Ingrese nombre de jugador 1: ");
        cajaJugadorUno.getChildren().addAll(cajaNombreJugadorUno);
        //Label labelJugadorDos = new Label("Ingrese nombre de jugador 2: ");
        //labelJugadorDos.getStyleClass().add("nombre");
        TextField cajaNombreJugadorDos = new TextField();
        cajaNombreJugadorDos.setFocusTraversable(false);
        cajaNombreJugadorUno.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        //cajaNombreJugadorDos.setAlignment(Pos.CENTER);
        cajaNombreJugadorDos.setPromptText("Ingrese nombre de jugador 2: ");
        cajaJugadorDos.getChildren().addAll(cajaNombreJugadorDos);
        cajaNombreJugadorDos.setFont(Font.font("Sans Serif", FontWeight.BOLD, 25));
        Button cargarJugadores = new Button("Empezar");
        cajaY.getChildren().addAll(imagen,cajaJugadorUno,cajaJugadorDos,cargarJugadores);
        CargarUsuarioHandler cargarUsuarioHandler = new CargarUsuarioHandler(kahoot,cajaNombreJugadorUno,cajaNombreJugadorDos,stage,mediaPlayer);
        cargarJugadores.setOnAction(cargarUsuarioHandler);
        cajaNombreJugadorUno.setPrefSize(500,50);
        cajaJugadorUno.setPrefSize(75,75);
        cajaJugadorDos.setPrefSize(75,75);
        cargarJugadores.setPrefSize(200,30);
        cajaNombreJugadorDos.setPrefSize(500,50);
        imagen.setAlignment(Pos.TOP_CENTER);
        cajaJugadorDos.setAlignment(Pos.CENTER);
        cajaJugadorUno.setAlignment(Pos.CENTER);
        cajaY.setAlignment(Pos.CENTER);
        this.setCenter(cajaY);

    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(kahoot,stage,mediaPlayer);
        this.setTop(menuBar);

    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}
