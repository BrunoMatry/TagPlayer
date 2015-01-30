package view.button;

import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.Log;
import model.MusicFile;
import model.Tag;
import view.window.AddTagDialog;

public class AddTagButton extends Button {
    private final MusicFile musicFile;

    public AddTagButton(MusicFile mf) {
        super();
        musicFile = mf;
        this.setOnAction((ActionEvent event) -> {
            AddTagDialog dialog = new AddTagDialog();         
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent() && !result.get().equals("")){
                addTagAction(result.get());
            }
        });
        this.setText("#");
    }
    
    private void addTagAction(String tagName) {
        Tag tag = new Tag(tagName);
        musicFile.addTag(tag);
        Log.addTagLog(musicFile.getName(), tag.getName());
    }
}
