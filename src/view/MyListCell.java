package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.media.Media;
import model.MusicFile;
import tools.MyMediaPlayer;


/******** TODO *********/
public class MyListCell extends ListCell<MusicFile> {
    private static HBox hbox;
    private MusicFile lastItem;
    private static MusicFileListView musicFileListView;
    private static final MyListCell INSTANCE = new MyListCell();

    private MyListCell() {
        super();
        hbox = new HBox();
    }
    
    public void setMusicFileListView(MusicFileListView mfls) {
        musicFileListView = mfls;
        for(MusicFile mf : mfls.musicFileList) {
            // hbox.getChildren().add(mf, label);
        }
        Label label = new Label("(empty)");
        Button button = new Button("(>)");
        Pane pane = new Pane();
        hbox.getChildren().addAll(label, pane, this.playButtonGenerator(0));
        HBox.setHgrow(pane, Priority.ALWAYS);
        
    }
    
    public static MyListCell getInstance() {
        return INSTANCE;
    }
    
    private Button playButtonGenerator(int i) {
        Button button = new Button("(>)");
        button.setOnAction((ActionEvent event) -> {
            Media m = musicFileListView.musicFileList.get(i).getMedia();
            MyMediaPlayer mediaPlayer = MyMediaPlayer.getInstance();
            mediaPlayer.setMedia(m);
            mediaPlayer.play();
            System.out.println(lastItem + " : " + event);
        });
        return button;
    }

    @Override
    protected void updateItem(MusicFile item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if (empty) {
            lastItem = null;
            setGraphic(null);
        } else {
            lastItem = item;
            setGraphic(hbox);
        }
    }
}
