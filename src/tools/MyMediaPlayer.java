package tools;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.MusicFile;

public class MyMediaPlayer {
    private static final MyMediaPlayer INSTANCE = new MyMediaPlayer();
    private MediaPlayer mediaplayer;
    private ArrayList<MusicFile> playlist;
    private Iterator<MusicFile> playListIterator;
    
    private MyMediaPlayer() {
        mediaplayer = null;
        playlist = new ArrayList<>();
        playListIterator = playlist.iterator();
    }
    
    public static void setPlaylist(ArrayList<MusicFile> pl) {
        INSTANCE.playlist = pl;
        INSTANCE.playListIterator = INSTANCE.playlist.iterator();
        playNextSong();
    }
    
    public static void setPlaylist(ArrayList<MusicFile> pl, MusicFile startingElement) {
        INSTANCE.playlist = pl;
        // Lecture du bon fichier
        INSTANCE.setMedia(startingElement.getMedia());
        // Placement iterateur
        INSTANCE.playListIterator = INSTANCE.playlist.iterator();
        while(!INSTANCE.playListIterator.next().equals(startingElement) && INSTANCE.playListIterator.hasNext());
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

    public static void playNextSong() {
        if(INSTANCE.playListIterator.hasNext()) {
            INSTANCE.setMedia(INSTANCE.playListIterator.next().getMedia());
        }
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
