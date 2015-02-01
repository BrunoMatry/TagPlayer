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
        List<MusicFile> musicFiles = MainWindow.getFullMusicFileList().getMusicFiles();
        Map<String, String> map = new HashMap<>();
        for(MusicFile mf : musicFiles) {
            if(!mf.getTags().isEmpty()) {
                String tags = "";
                for(Tag t : mf.getTags()) {
                    tags +=  ApplicationParameters.FILE_SEPARATOR + t.getName();
                }
                map.put(mf.getFile().getAbsolutePath(), tags);
            }
        }
        MyFileWriter.saveDataBase(map);
        Log.onCloseLog();
        Platform.exit();
        System.exit(0);
    }
    
}
