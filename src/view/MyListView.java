package view;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import model.MusicFile;

public class MyListView extends ListView<MyHBoxCell> {

    public MyListView(List<MusicFile> musicFileList) {
        super();
        List<MyHBoxCell> hboxCellList = new ArrayList<>();
        for (MusicFile mf : musicFileList) {
            hboxCellList.add(new MyHBoxCell(mf));
        }
        ObservableList<MyHBoxCell> myObservableList = FXCollections.observableList(hboxCellList);
        this.setItems(myObservableList);
    }
}
