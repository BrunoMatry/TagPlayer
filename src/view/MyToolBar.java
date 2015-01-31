package view;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import view.button.PauseButton;
import view.button.StopButton;

public class MyToolBar extends ToolBar {

    public MyToolBar() {
        super();
        this.getItems().addAll(
                new PauseButton(),
                new StopButton(),
                new Separator()
            );
    }
}
