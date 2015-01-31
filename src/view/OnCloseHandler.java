package view;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import model.Log;


public class OnCloseHandler implements EventHandler<WindowEvent> {

    public OnCloseHandler() {
    }

    @Override
    public void handle(WindowEvent t) {
        // TODO Sauvegarde de la DBA
        Log.onCloseLog();
        Platform.exit();
        System.exit(0);
    }
    
}
