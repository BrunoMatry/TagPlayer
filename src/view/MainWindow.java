package view;

import controller.ApplicationParameters;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.MusicFile;

public class MainWindow {
    private static Stage primaryStage;
    private static StackPane root;
    private static Scene scene;
    private static MusicFileListView listView;
    private static final MainWindow INSTANCE = new MainWindow();
    
    private MainWindow() {
        root = new StackPane();
        scene = new Scene(
            root,
            ApplicationParameters.DEFAULT_WIDTH,
            ApplicationParameters.DEFAULT_HEIGHT
        );
    }

    public void initialize(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle(ApplicationParameters.APPLICATION_NAME);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void setMusicFileList(List<MusicFile> list) {
        listView = new MusicFileListView(list);
        root.getChildren().add(listView);
        primaryStage.show();
    }

    public static MainWindow getInstance() {
        return INSTANCE;
    }
}