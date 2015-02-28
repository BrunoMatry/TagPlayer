package model;

import controller.exception.MusicFileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayList {
    protected final List<MusicFile> musicFiles;
    
    public PlayList() {
        musicFiles = new ArrayList<>();
    }

    public PlayList(List<MusicFile> list) {
        musicFiles = list;
    }

    public List<MusicFile> getMusicFiles() {
        return musicFiles;
    }

    public List<MusicFile> getMusicFilesWithTag(Tag t) {
        List<MusicFile> list = new ArrayList<>();
        for(MusicFile mf : musicFiles) {
            if(mf.getTags().contains(t)) {
                list.add(mf);
            }
        }
        return list;
    }

    public MusicFile getNextMusicFile(MusicFile musicFile) throws MusicFileNotFoundException {
        if(!musicFiles.contains(musicFile)) {
            throw new MusicFileNotFoundException();
        }
        Iterator<MusicFile> i = musicFiles.iterator();
        while(i.hasNext()){
            if(i.next().equals(musicFile)) {
                if(i.hasNext()) {
                    return i.next();
                }
                break;
            }
        }
        throw new MusicFileNotFoundException();
    }
}
