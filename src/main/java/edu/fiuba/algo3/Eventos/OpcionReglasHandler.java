package edu.fiuba.algo3.Eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class OpcionReglasHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reglas");
        alert.setHeaderText("Reglas de Kahoot 2");
        String mensaje = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc at nunc eu enim mollis laoreet nec id ipsum. Aenean accumsan odio sed vehicula ullamcorper. Nullam sit amet tellus vel justo ultricies interdum. Curabitur porttitor risus luctus nisi aliquet ultrices. Vestibulum scelerisque finibus nisi sed iaculis. Maecenas at consequat dui, sit amet ultricies nulla. Etiam posuere tempor metus ac hendrerit.\n" +
                "\n" +
                "Maecenas egestas ultrices nunc non pretium. Suspendisse nunc sapien, faucibus ac tortor eget, porta consectetur enim. Integer non tempor mauris, non tincidunt ex. Donec et sem tincidunt, faucibus elit ut, volutpat neque. Nam non fermentum augue, eget egestas nibh. Duis pulvinar lacus eu magna ullamcorper dignissim. Praesent eleifend lectus purus, ut lobortis ipsum commodo id. Integer vehicula augue in dolor mattis rhoncus. Vestibulum tempor maximus mi vitae congue. Duis condimentum ipsum eu urna gravida, ac convallis orci eleifend.\n" +
                "\n" +
                "Aliquam erat volutpat. Nulla facilisi. Aenean a erat sed massa porta posuere sed eu enim. Integer consequat euismod dolor sed rutrum. In a eros a mauris porta rhoncus sit amet eget felis. Nam fringilla tempus dictum. Maecenas non ullamcorper nunc. Proin euismod odio quis rutrum egestas. Vivamus ex ligula, congue dictum velit vitae, congue efficitur leo.\n" +
                "\n" +
                "Cras a mi nunc. Nulla facilisi. Cras pellentesque id augue vel gravida. Cras ultricies gravida purus a semper. Nam eu convallis nibh. Phasellus non est vitae urna iaculis mattis. In eget lobortis ipsum. Nunc maximus non felis et lobortis.\n" +
                "\n" +
                "Quisque tincidunt nibh tellus, quis feugiat magna placerat vel. Donec et felis vel magna aliquam elementum id volutpat justo. Vestibulum ac pretium tortor. Curabitur quis felis lectus. Aenean gravida elit imperdiet, luctus lectus maximus, sodales augue. Duis a risus aliquet leo tempus pellentesque at non lorem. In quis auctor lectus. Curabitur placerat luctus libero eu viverra. Etiam sollicitudin lectus leo, ac lacinia justo ullamcorper sed. Duis tempor blandit turpis et lobortis. Proin feugiat, tellus in ullamcorper accumsan, sapien sapien rhoncus urna, at viverra turpis purus et urna. Aliquam feugiat blandit elit sit amet porta.";
        alert.setContentText(mensaje);
        alert.show();
    }
}
