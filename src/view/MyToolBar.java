package view;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import view.button.PauseButton;
import view.button.StopButton;

public class MyToolBar extends ToolBar {

    public MyToolBar() {
        // TODO
        super();
        TextField textField = new TextField ("Search a song...");
        Button btn1 = new Button("|<<");
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
                new PauseButton(),
                btn2,
                new StopButton(),
                new Separator(),
                chkSound,
                chkMusic
            );
        // Second Toolbar : progression bar, currently play song and tags, current playlist
    }
    
}
