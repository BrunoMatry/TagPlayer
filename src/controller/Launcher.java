package controller;
 
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.MusicFile;
import model.MusicFileList;
 
public class Launcher extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // TODO
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("TagPlayer");
        primaryStage.setScene(scene);
        primaryStage.show();
        MusicFileList musicFileList = new MusicFileList();
        musicFileList.getMusicFilesFromPath("E:\\Google Drive\\A transférer");
        List<MusicFile> files = musicFileList.getMusicFiles();
        for(MusicFile mf : files) {
            System.out.println(mf.getFile().getName());
        }
        
        MusicFile mf = files.get(0);
        
        MediaPlayer mediaPlayer = new MediaPlayer(mf.getMedia());
        mediaPlayer.play();
    }
    public static void main(String[] args) {
        launch(args);
    }
}