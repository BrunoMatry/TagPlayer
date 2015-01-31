package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;

public class DetailsButton extends Button {

    public DetailsButton(MusicFile mf) {
        super();
        this.setOnAction((ActionEvent event) -> {
        });
        this.setText("Details");
    }
    
}
