package view.button;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import tools.MyMediaPlayer;

public class PlayButton extends Button {

    public PlayButton(MusicFile mf) {
        super();
        this.setOnAction((ActionEvent event) -> {
            ArrayList<MusicFile> musicFileList = new ArrayList<>();
            musicFileList.add(mf);
            MyMediaPlayer.setPlaylist(musicFileList);
            MyMediaPlayer.play();
        });
        this.setText(">");
    }
}
