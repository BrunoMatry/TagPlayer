package view.button;

import java.util.List;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import model.MusicFileList;
import model.Tag;
import view.window.MainWindow;

public class TagButton extends Button {

    public TagButton(Tag tag) {
        super();
        this.setOnAction((ActionEvent event) -> {
            List<MusicFile> list = MainWindow.getFullMusicFileList().getMusicFilesWithTag(tag);
            MainWindow.setMusicFileList(new MusicFileList(list));
        });
        this.setText(tag.getName());
    }
}
