package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import tools.MyMediaPlayer;

public class NextSongButton extends Button {
    public NextSongButton() {
        super();
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer.playNextSong();
        });
        this.setText(">>|");
    }
}
