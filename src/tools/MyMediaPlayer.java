package tools;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyMediaPlayer {
    private static final MyMediaPlayer INSTANCE = new MyMediaPlayer();
    private MediaPlayer mediaplayer;
    
    private MyMediaPlayer() {
        mediaplayer = null;
    }
    
    public static void setMedia(Media m) {
        if(INSTANCE.mediaplayer != null) {
            INSTANCE.mediaplayer.dispose();
        }
        INSTANCE.mediaplayer = new MediaPlayer(m);
    }
    
    public static void play() {
        INSTANCE.mediaplayer.play();
    }
    
    public static void stop() {
        INSTANCE.mediaplayer.stop();
    }

    public static void pause() {
        INSTANCE.mediaplayer.pause();
    }
}
