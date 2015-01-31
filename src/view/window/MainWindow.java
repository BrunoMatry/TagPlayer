package view.window;

import controller.ApplicationParameters;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.MusicFileList;
import view.MyListView;
import view.MyToolBar;
import view.OnCloseHandler;

public class MainWindow {

    private Stage primaryStage;
    private final BorderPane root;
    private final StackPane musicFileStackPane;
    private final Scene scene;
    private static final MainWindow INSTANCE = new MainWindow();
    private MyListView fulllListView;
    private MusicFileList fullMusicFileList;
    private MusicFileList currentMusicFileList;
    
    private MainWindow() {
        root = new BorderPane();
        musicFileStackPane = new StackPane();
        scene = new Scene(
            root,
            ApplicationParameters.DEFAULT_WIDTH,
            ApplicationParameters.DEFAULT_HEIGHT
        );
        root.setTop(new MyToolBar());
        root.setCenter(musicFileStackPane);
    }

    public static void initialize(Stage stage, MusicFileList list) {
        INSTANCE.primaryStage = stage;
        INSTANCE.fullMusicFileList = list;
        INSTANCE.currentMusicFileList = list;
        INSTANCE.primaryStage.setTitle(ApplicationParameters.APPLICATION_NAME);
        INSTANCE.primaryStage.setScene(INSTANCE.scene);
        INSTANCE.fulllListView = new MyListView(INSTANCE.fullMusicFileList.getMusicFiles());
        INSTANCE.primaryStage.setOnCloseRequest(new OnCloseHandler());
        INSTANCE.musicFileStackPane.getChildren().add(INSTANCE.fulllListView);
        INSTANCE.primaryStage.show();
    }

    public static void setMusicFileList(MusicFileList filteredList) {
        INSTANCE.musicFileStackPane.getChildren().clear();
        INSTANCE.musicFileStackPane.getChildren().add(new MyListView(filteredList.getMusicFiles()));
        INSTANCE.currentMusicFileList = filteredList;
    }
    
    public static void setFullMusicFileList() {
        INSTANCE.musicFileStackPane.getChildren().clear();
        INSTANCE.musicFileStackPane.getChildren().add(INSTANCE.fulllListView);
    }

    public static MusicFileList getFullMusicFileList() {
        return INSTANCE.fullMusicFileList;
    }
    
    public static MusicFileList getCurrentMusicFileList() {
        return INSTANCE.currentMusicFileList;
    }
}
