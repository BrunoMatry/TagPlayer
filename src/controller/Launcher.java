package controller;
 
import javafx.application.Application;
import javafx.stage.Stage;
import model.MusicFileList;
import view.window.MainWindow;
 
public class Launcher extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Create MainWindow instance
        MainWindow mainWindow = MainWindow.getInstance();
        mainWindow.initialize(primaryStage);

        // Generate a MusicFile list
        MusicFileList musicFileList = new MusicFileList();
        musicFileList.findMusicFilesFromPath(ApplicationParameters.DEFAULT_PATH);
        mainWindow.setMusicFileList(musicFileList);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
