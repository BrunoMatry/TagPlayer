package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import tools.MyMediaPlayer;

public class PauseButton extends Button {

    public PauseButton() {
        super();
        fromPlayToPause();
    }
    
    private void fromPlayToPause() {
        this.setText("Pause");
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer.pause();
            fromPauseToPlay();
        });
    }

    private void fromPauseToPlay() {
        this.setText("Play");
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer.play();
            fromPlayToPause();
        });
    }
}
