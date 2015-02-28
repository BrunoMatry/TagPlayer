package tools;

import java.util.ArrayList;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.MusicFile;

public class MyMediaPlayer {
    private static final MyMediaPlayer INSTANCE = new MyMediaPlayer();
    private MediaPlayer mediaplayer;
    private ArrayList<MusicFile> playlist;
    private int currentElementIndex;
    
    private MyMediaPlayer() {
        mediaplayer = null;
        playlist = new ArrayList<>();
        currentElementIndex = -1;
    }
    
    public static void setPlaylist(ArrayList<MusicFile> pl, MusicFile startingElement) {
        INSTANCE.playlist = pl;
        INSTANCE.setMedia(startingElement.getMedia());
        INSTANCE.currentElementIndex = INSTANCE.playlist.indexOf(startingElement);
    }
    
    public static void play() {
        if(INSTANCE.isPlayerValid()) {
            INSTANCE.mediaplayer.play();
        }
    }
    
    public static void stop() {
        if(INSTANCE.isPlayerValid()) {
            INSTANCE.mediaplayer.stop();
        }
    }

    public static void pause() {
        if(INSTANCE.isPlayerValid()) {
            INSTANCE.mediaplayer.pause();
        }
    }

    public static void playNextSong() {
        if(INSTANCE.isPlayerValid() && INSTANCE.currentElementIndex < INSTANCE.playlist.size()-1) {
            INSTANCE.currentElementIndex++;
            INSTANCE.setMedia(
                INSTANCE.playlist.get(
                    INSTANCE.currentElementIndex
                ).getMedia()
            );
        }
    }

    public static void playPreviousSong() {
        if(INSTANCE.isPlayerValid() && INSTANCE.currentElementIndex > 0) {
            INSTANCE.currentElementIndex--;
            INSTANCE.setMedia(
                INSTANCE.playlist.get(
                    INSTANCE.currentElementIndex
                ).getMedia()
            );
        }
    }
    
    private boolean isPlayerValid() {
        return INSTANCE.mediaplayer != null
            && INSTANCE.currentElementIndex < INSTANCE.playlist.size()
            && INSTANCE.currentElementIndex > -1;
    }

    private void setMedia(Media m) {
        if(mediaplayer != null) {
            mediaplayer.dispose();
        }
        mediaplayer = new MediaPlayer(m);
        mediaplayer.setAutoPlay(true);
        mediaplayer.setOnEndOfMedia(() -> playNextSong());
    }
}
