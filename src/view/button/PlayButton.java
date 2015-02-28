package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import tools.MyMediaPlayer;
import view.window.MainWindow;

public class PlayButton extends Button {

    public PlayButton(MusicFile mf) {
        super();
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer.setPlaylist(MainWindow.getCurrentMusicFileList(), mf);
            MyMediaPlayer.play();
        });
        this.setText(">");
    }
}
