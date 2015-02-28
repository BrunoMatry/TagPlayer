package view.window;

import controller.ApplicationParameters;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.MusicFile;
import tools.comparator.AscendingAgeMusicFileComparator;
import tools.database.MyFileReader;
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

    private ArrayList<MusicFile> fullMusicFileList;
    private ArrayList<MusicFile> currentMusicFileList;
    
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

    public static void initialize(Stage stage, ArrayList<MusicFile> list) {
        list.sort(new AscendingAgeMusicFileComparator());
        INSTANCE.primaryStage = stage;
        MyFileReader.loadInDba(list);
        INSTANCE.fullMusicFileList = list;
        INSTANCE.currentMusicFileList = list;
        INSTANCE.primaryStage.setTitle(ApplicationParameters.APPLICATION_NAME);
        INSTANCE.primaryStage.setScene(INSTANCE.scene);
        INSTANCE.fulllListView = new MyListView(INSTANCE.fullMusicFileList);
        INSTANCE.primaryStage.setOnCloseRequest(new OnCloseHandler());
        INSTANCE.musicFileStackPane.getChildren().add(INSTANCE.fulllListView);
        INSTANCE.primaryStage.show();
    }

    public static void setMusicFileList(ArrayList<MusicFile> filteredList) {
        INSTANCE.musicFileStackPane.getChildren().clear();
        INSTANCE.musicFileStackPane.getChildren().add(new MyListView(filteredList));
        INSTANCE.currentMusicFileList = filteredList;
    }
    
    public static void setFullMusicFileList() {
        INSTANCE.musicFileStackPane.getChildren().clear();
        INSTANCE.musicFileStackPane.getChildren().add(INSTANCE.fulllListView);
    }

    public static ArrayList<MusicFile> getFullMusicFileList() {
        return INSTANCE.fullMusicFileList;
    }
    
    public static ArrayList<MusicFile> getCurrentMusicFileList() {
        return INSTANCE.currentMusicFileList;
    }
}
