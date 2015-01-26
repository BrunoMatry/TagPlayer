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

    public List<MusicFile> getMusicFiles() {
        return files;
    }

    public void getMusicFilesFromPath(String path) {
        Filewalker fw = new Filewalker(path);
        List<File> walkedFiles = fw.getFiles();
        for(File f : walkedFiles) {
            if(FileTool.getFileExtension(f).equals("MP3")) {
                files.add(new MusicFile(f));
            }
        }
    }
}
