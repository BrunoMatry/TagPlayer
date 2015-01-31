package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import tools.MyMediaPlayer;

public class StopButton extends Button {
    
    public StopButton() {
        super();
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer.getInstance().stop();
        });
        this.setText("Stop");
    }
}
