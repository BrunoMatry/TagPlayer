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
    private final MusicFile musicFile;

    public MyHBoxCell(MusicFile mf) {
        super();
        musicFile = mf;
        label = new Label(musicFile.getName());
        label.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(label, Priority.ALWAYS);     
        refresh();
    }
    
    public final void refresh() {
        this.getChildren().clear();
        this.getChildren().addAll(label, new PlayButton(musicFile));
        for(Tag t : musicFile.getTags()) {
            this.getChildren().addAll(new TagButton(t));
        }
        this.getChildren().addAll(new AddTagButton(musicFile, this)/*, new DetailsButton(musicFile)*/);
    }
}
