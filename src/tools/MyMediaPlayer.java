package tools;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyMediaPlayer {
    private static final MyMediaPlayer INSTANCE = new MyMediaPlayer();
    private static MediaPlayer mediaplayer;
    
    private MyMediaPlayer() {
        mediaplayer = null;
    }
    
    public static MyMediaPlayer getInstance() {
        return INSTANCE;
    }
    
    public void setMedia(Media m) {
        if(mediaplayer != null) {
            mediaplayer.dispose();
        }
        mediaplayer = new MediaPlayer(m);
    }
    
    public void play() {
        mediaplayer.play();
    }
    
    public void stop() {
        mediaplayer.stop();
    }
}
