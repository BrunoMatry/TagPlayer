package view.button;

import javafx.scene.control.Button;
import model.Tag;

public class TagButton extends Button {

    public TagButton(Tag tag) {
        super();
        this.setText(tag.getName());
    }
}
