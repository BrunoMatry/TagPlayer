package controller;
 
import javafx.application.Application;
import javafx.stage.Stage;
import model.Log;
import tools.MusicFileTool;
import view.window.MainWindow;
 
public class Launcher extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Log.onOpeningLog();
        MainWindow.initialize(
            primaryStage,
            MusicFileTool.findMusicFilesFromPath(ApplicationParameters.DEFAULT_PATH)
        );
    }
    public static void main(String[] args) {
        launch(args);
    }
}
