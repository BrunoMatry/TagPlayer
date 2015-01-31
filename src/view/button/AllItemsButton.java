package view.button;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import view.window.MainWindow;

public class AllItemsButton extends Button {
    public AllItemsButton() {
        super();
        this.setOnAction((ActionEvent event) -> {
            MainWindow.setFullMusicFileList();
        });
        this.setText("See all songs");
    }
}
