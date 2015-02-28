package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import tools.MyMediaPlayer;

public class PreviousSongButton extends Button {
    public PreviousSongButton() {
        super();
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer.playPreviousSong();
        });
        this.setText("|<<");
    }
}
