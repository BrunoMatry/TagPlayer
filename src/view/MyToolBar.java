package view;

import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import view.button.AllItemsButton;
import view.button.NextSongButton;
import view.button.PauseButton;
import view.button.PreviousSongButton;
import view.button.SortByAscendingAgeButton;
import view.button.SortByAscendingNameButton;
import view.button.StopButton;

public class MyToolBar extends ToolBar {

    public MyToolBar() {
        super();
        this.getItems().addAll(
            new PauseButton(),
            new PreviousSongButton(),
            new StopButton(),
            new NextSongButton(),
            new Separator(),
            new AllItemsButton(),
            new SortByAscendingNameButton(),
            new SortByAscendingAgeButton()
        );
    }
}
