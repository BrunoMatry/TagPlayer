package view;

import controller.ApplicationParameters;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.MusicFile;

public class MainWindow {
    private static Stage primaryStage;
    private static BorderPane root;
    private static StackPane musicFileStackPane;
    private static Scene scene;
    private static final MainWindow INSTANCE = new MainWindow();
    private static MyListView listView;
    
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

    public void setMusicFileList(List<MusicFile> list) {
        if(listView != null) {
            root.getChildren().remove(list);
        }
        listView = new MyListView(list);
        musicFileStackPane.getChildren().add(listView);
        primaryStage.show();
    }

    public static MainWindow getInstance() {
        return INSTANCE;
    }
}