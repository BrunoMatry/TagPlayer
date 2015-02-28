package view.button;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import tools.comparator.AscendingNameMusicFileComparator;
import view.window.MainWindow;

public class SortByAscendingNameButton extends Button {

    public SortByAscendingNameButton() {
        super();
        this.setOnAction((ActionEvent event) -> {
            ArrayList<MusicFile> list = MainWindow.getCurrentMusicFileList();
            list.sort(new AscendingNameMusicFileComparator());
            MainWindow.setMusicFileList(list);
        });
        this.setText("Sort >name");
    }
}
