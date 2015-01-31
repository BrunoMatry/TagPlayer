package view.window;

import controller.ApplicationParameters;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.MusicFile;
import model.MusicFileList;
import view.MyListView;
import view.MyToolBar;

public class MainWindow {
    private static Stage primaryStage;
    private static BorderPane root;
    private static StackPane musicFileStackPane;
    private static Scene scene;
    private static final MainWindow INSTANCE = new MainWindow();
    private static MyListView listView;
    private static MusicFileList musicFileList;
    
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

    public void initialize(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle(ApplicationParameters.APPLICATION_NAME);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setMusicFileList(MusicFileList list) {
        musicFileList = list;
        listView = new MyListView(musicFileList.getMusicFiles());
        musicFileStackPane.getChildren().add(listView);
        primaryStage.show();
    }

    public static MainWindow getInstance() {
        return INSTANCE;
    }
    
    public MusicFileList getMusicFileList() {
        return musicFileList;
    }
}
