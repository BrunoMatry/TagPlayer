package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import tools.MyMediaPlayer;

public class PlayButton extends Button {

    public PlayButton(MusicFile mf) {
        super();
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer.setMedia(mf.getMedia());
            MyMediaPlayer.play();
        });
        this.setText(">");
    }
}
