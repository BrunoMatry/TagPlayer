package view.window;

import javafx.scene.control.TextInputDialog;

public class AddTagDialog extends TextInputDialog {

    public AddTagDialog() {
        super();
        this.setTitle("Add a tag");
        this.setContentText("Enter tag's name:");
    }
}
