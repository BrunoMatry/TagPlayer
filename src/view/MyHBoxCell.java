package view;

import view.button.PlayButton;
import view.button.DetailsButton;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import model.MusicFile;
import model.Tag;
import view.button.AddTagButton;
import view.button.TagButton;

public class MyHBoxCell extends HBox {
    private final Label label;

    MyHBoxCell(MusicFile musicFile) {
        super();
        label = new Label(musicFile.getFile().getName());
        label.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(label, Priority.ALWAYS);     
        this.getChildren().addAll(label, new PlayButton(musicFile));
        for(Tag t : musicFile.getTags()) {
            this.getChildren().addAll(new TagButton(t));
        }
        this.getChildren().addAll(new AddTagButton(musicFile), new DetailsButton(musicFile));
    }
}
