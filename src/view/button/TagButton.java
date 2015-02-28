package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.Tag;
import tools.MusicFileTool;
import view.window.MainWindow;

public class TagButton extends Button {

    public TagButton(Tag tag) {
        super();
        this.setOnAction((ActionEvent event) -> {
            MainWindow.setMusicFileList(
                MusicFileTool.filterByTag(
                    MainWindow.getFullMusicFileList(),
                    tag
                )
            );
        });
        this.setText(tag.getName());
    }
}
