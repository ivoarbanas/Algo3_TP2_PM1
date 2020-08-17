package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.GroupChoice;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class EnviarRespuestaGroupChoiceHandler extends EnviarRespuestaHandler {

    ArrayList<HBox> botonesOpciones;

    public EnviarRespuestaGroupChoiceHandler(Kahoot kahoot, Stage stage, ToggleGroup grupoMultiplicadores, ArrayList<HBox> botonesOpciones, ArrayList<ToggleButton> botonesMultiplicadores, Pregunta pregunta, ContenedorPregunta contenedor){
        super(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
        this.botonesOpciones = botonesOpciones;
    }

    @Override
    public void handle(ActionEvent event) {

        ArrayList<Opcion> opcionElegida = new ArrayList<>();
        for(int ordenSpinner = 0; ordenSpinner < botonesOpciones.size(); ordenSpinner++){
            Spinner spinner = (Spinner)botonesOpciones.get(ordenSpinner).getChildren().get(1);
            Label label = (Label)botonesOpciones.get(ordenSpinner).getChildren().get(0);
            if(spinner.getValue().equals(((GroupChoice)pregunta).grupoUno())){
                opcionElegida.add(new Opcion(label.getText()));
            }

        }
        for(int ordenSpinner = 0; ordenSpinner < botonesOpciones.size(); ordenSpinner++){
            Spinner spinner = (Spinner)botonesOpciones.get(ordenSpinner).getChildren().get(1);
            spinner.decrement(6);

        }

        contenedor.getJugadorActivo().cargarRespuestas(opcionElegida);
        EnviarRespuestaHandler multiplicadorHandler = new EnviarRespuestaHandler(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
        multiplicadorHandler.handle(event);
        //}
    }
}
