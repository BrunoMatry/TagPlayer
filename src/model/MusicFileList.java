package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tools.FileTool;
import tools.Filewalker;

public class MusicFileList {
    private final List<MusicFile> files;
    
    public MusicFileList() {
        files = new ArrayList<>();
    }

    public MusicFileList(List<MusicFile> list) {
        files = list;
    }

    public List<MusicFile> getMusicFiles() {
        return files;
    }

    public void findMusicFilesFromPath(String path) {
        Filewalker fw = new Filewalker(path);
        List<File> walkedFiles = fw.getFiles();
        for(File f : walkedFiles) {
            if(FileTool.getFileExtension(f).equals("MP3")) {
                files.add(new MusicFile(f));
            }
        }
    }

    public List<MusicFile> getMusicFilesWithTag(Tag t) {
        List<MusicFile> list = new ArrayList<>();
        for(MusicFile mf : files) {
            if(mf.getTags().contains(t)) {
                list.add(mf);
            }
        }
        return list;
    }
}
