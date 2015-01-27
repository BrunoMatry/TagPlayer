package view;

import tools.MyMediaPlayer;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.media.Media;
import model.MusicFile;

public final class MusicFileListView extends ListView<MusicFile>{
    private List<MusicFile> musicFileList;
    private final ObservableList data;
    
    public MusicFileListView(List<MusicFile> list) {
        data = FXCollections.observableArrayList();
        this.setData(list);
        this.setEditable(false);
        this.setItems(data);
        this.setOnMouseClicked(new MyEventHandler(this));
    }
    
    public void setData(List<MusicFile> list) {
        data.clear();
        musicFileList = list;
        for(MusicFile mf : musicFileList) {
            data.add(mf);
        }
    }
    
    private class MyEventHandler implements EventHandler {
        private final MusicFileListView musicFileListView;

        public MyEventHandler(MusicFileListView mfls) {
            musicFileListView = mfls;
        }

        @Override
        public void handle(Event t) {
            int i = musicFileListView.getFocusModel().getFocusedIndex();
            Media m = musicFileList.get(i).getMedia();
            MyMediaPlayer mediaPlayer = MyMediaPlayer.getInstance();
            mediaPlayer.setMedia(m);
            mediaPlayer.play();
        }
   }
}
