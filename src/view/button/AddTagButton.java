package view.button;

import controller.ApplicationParameters;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.Log;
import model.MusicFile;
import view.MyHBoxCell;
import view.window.AddTagDialog;

public class AddTagButton extends Button {
    private final MusicFile musicFile;
    private final MyHBoxCell cell;

    public AddTagButton(MusicFile mf, MyHBoxCell c) {
        super();
        musicFile = mf;
        cell = c;
        this.setOnAction((ActionEvent event) -> {
            AddTagDialog dialog = new AddTagDialog();         
            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()
               && !result.get().equals("")
               && !result.get().contains(ApplicationParameters.FILE_SEPARATOR)){
                addTagAction(result.get());
            }
        });
        this.setText("#");
    }
    
    private void addTagAction(String tagName) {
        musicFile.addTag(tagName);
        cell.refresh();
        Log.addTagLog(musicFile.getName(), tagName);
    }
}
