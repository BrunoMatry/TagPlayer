package view;

import controller.ApplicationParameters;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import model.Log;
import model.MusicFile;
import model.Tag;
import tools.database.MyFileWriter;
import view.window.MainWindow;


public class OnCloseHandler implements EventHandler<WindowEvent> {

    @Override
    public void handle(WindowEvent e) {
        saveDatabase();
        Log.onCloseLog();
        Platform.exit();
        System.exit(0);
    }
    
    private void saveDatabase() {
        List<MusicFile> musicFiles = MainWindow.getFullMusicFileList().getMusicFiles();
        Map<String, List<Tag>> map = new HashMap<>();
        for(MusicFile mf : musicFiles) {
            if(!mf.getTags().isEmpty()) {
                map.put(mf.getFile().getAbsolutePath(), mf.getTags());
            }
        }
        MyFileWriter.saveDataBase(map);
    }
}
