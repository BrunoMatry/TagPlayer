package view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import view.button.StopButton;

public class MyToolBar extends ToolBar {

    public MyToolBar() {
        // TODO
        super();
        TextField textField = new TextField ("Search a song...");
        Button btn1 = new Button("|<<");
        Button btnNew = new Button("Pause");
        Button btn2 = new Button(">>|");
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
                new StopButton(),
                new Separator(),
                chkSound,
                chkMusic
            );
        // Second Toolbar : progression bar, currently play song and tags, current playlist
    }
    
}
