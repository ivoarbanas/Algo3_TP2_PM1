package edu.fiuba.algo3;

import edu.fiuba.algo3.Eventos.*;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar{

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Kahoot kahoot, Stage stage) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionReglas = new MenuItem("Reglas");
        MenuItem opcionNuevo = new MenuItem("Nuevo");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionReglasHandler opcionReglasHandler = new OpcionReglasHandler();
        opcionReglas.setOnAction(opcionReglasHandler);

        OpcionNuevoHandler opcionNuevoHandler = new OpcionNuevoHandler(kahoot, stage);
        opcionNuevo.setOnAction(opcionNuevoHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionPantallaCompletaEventHandler opcionPantallaCompletaHandler = new OpcionPantallaCompletaEventHandler(stage, opcionPantallaCompleta);
        opcionPantallaCompleta.setOnAction(opcionPantallaCompletaHandler);

        opcionPantallaCompleta.setDisable(true);

        menuArchivo.getItems().addAll(opcionNuevo, new SeparatorMenuItem(), opcionSalir);
        menuAyuda.getItems().addAll(opcionReglas,opcionAcercaDe);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);

    }
}
