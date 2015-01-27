package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.MusicFile;

public class AddTagButton extends Button {

    public AddTagButton(MusicFile mf) {
        super();
        this.setOnAction((ActionEvent event) -> {
            Stage stage = new Stage();
            stage.setTitle("Add a tag");
            // Resize
            stage.show();
        });
        this.setText("+");
    }
}
