package edu.fiuba.algo3.Eventos;

import edu.fiuba.algo3.ContenedorPregunta;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.Pregunta;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Spliterator;

public class EnviarRespuestaOrderedChoiceHandler extends EnviarRespuestaHandler {

    ArrayList<Spinner> botonesOpciones;

    public EnviarRespuestaOrderedChoiceHandler(Kahoot kahoot, Stage stage, ToggleGroup grupoMultiplicadores, ArrayList<Spinner> botonesOpciones, ArrayList<ToggleButton> botonesMultiplicadores, Pregunta pregunta, ContenedorPregunta contenedor){
        super(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
        this.botonesOpciones = botonesOpciones;
    }

    @Override
    public void handle(ActionEvent event) {
        ArrayList<Opcion> opcionElegida = new ArrayList<>();
        for (Spinner unaOpcion: botonesOpciones){
            String valor = (String) unaOpcion.getValue();
            opcionElegida.add(new Opcion(valor));
            unaOpcion.decrement(6);
        }
        Boolean eligioRepetida = false;
        for(int i = 0; i < opcionElegida.size(); i++){
             Opcion unaOpcion = opcionElegida.get(i);
            for(int j = 0; j < opcionElegida.size(); j++){
                Opcion otraOpcion = opcionElegida.get(j);
                if((i != j) && (unaOpcion.valor() == otraOpcion.valor())){
                    eligioRepetida = true;
                }
            }
        }

        if(eligioRepetida) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Seleccione una respuesta válida:");
            String mensaje = "Presione OK para continuar";
            alert.setContentText(mensaje);
            alert.show();
        }

        else{
            contenedor.getJugadorActivo().cargarRespuestas(opcionElegida);
            EnviarRespuestaHandler multiplicadorHandler = new EnviarRespuestaHandler(kahoot, stage,  grupoMultiplicadores,  botonesMultiplicadores,  pregunta,  contenedor);
            multiplicadorHandler.handle(event);
        }
    }
}