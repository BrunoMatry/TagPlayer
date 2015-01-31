package view;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;


public class OnCloseHandler implements EventHandler<WindowEvent> {

    public OnCloseHandler() {
    }

    @Override
    public void handle(WindowEvent t) {
        // TODO Sauvegarde de la DBA
        Platform.exit();
        System.exit(0);
    }
    
}
