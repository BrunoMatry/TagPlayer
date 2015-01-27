package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import tools.MyMediaPlayer;

public class DetailsButton extends Button {

    public DetailsButton(MusicFile mf) {
        super();
        this.setOnAction((ActionEvent event) -> {
            MyMediaPlayer mediaPlayer = MyMediaPlayer.getInstance();
            mediaPlayer.setMedia(mf.getMedia());
            mediaPlayer.play();
        });
        this.setText("Détails");
    }
    
}
