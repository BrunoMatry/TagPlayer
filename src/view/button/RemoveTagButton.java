package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import model.Tag;
import view.MyHBoxCell;

public class RemoveTagButton extends Button {

    public RemoveTagButton(Tag tag, MusicFile mf, MyHBoxCell cell) {
        super();
        this.setOnAction((ActionEvent event) -> {
            mf.removeTag(tag);
            cell.refresh();
        });
        this.setText("x");
    }
    
}
