package view.button;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import model.MusicFile;
import tools.comparator.AscendingAgeMusicFileComparator;
import view.window.MainWindow;

public class SortByAscendingAgeButton extends Button {

    public SortByAscendingAgeButton() {
        super();
        this.setOnAction((ActionEvent event) -> {
            ArrayList<MusicFile> list = MainWindow.getCurrentMusicFileList();
            list.sort(new AscendingAgeMusicFileComparator());
            MainWindow.setMusicFileList(list);
        });
        this.setText("Sort >age");
    }
}
