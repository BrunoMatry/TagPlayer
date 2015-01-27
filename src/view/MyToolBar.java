package view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;

public class MyToolBar extends ToolBar {

    public MyToolBar() {
        // TODO
        super();
        TextField textField = new TextField ("Search a song...");
        Button btn1 = new Button("|<<");
        Button btnNew = new Button("Pause");
        Button btn2 = new Button(">>|");
        Button btnPause = new Button("Stop");
        Button btnQuit = new Button("Sort by");
        CheckBox chkSound = new CheckBox("Random");
        CheckBox chkMusic = new CheckBox("Loop");
        this.getItems().addAll(
                textField,
                new Separator(),
                btnQuit,
                new Separator(),
                btn1,
                btnNew,
                btn2,
                btnPause,
                
                new Separator(),
                chkSound,
                chkMusic
            );
        // Second Toolbar : progression bar, currently play song and tags, current playlist
    }
    
}
