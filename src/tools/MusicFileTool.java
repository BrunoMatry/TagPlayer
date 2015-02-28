package tools;

import java.io.File;
import java.util.ArrayList;
import model.MusicFile;
import model.Tag;

public class MusicFileTool {
    public static ArrayList<MusicFile> findMusicFilesFromPath(String path) {
        ArrayList<MusicFile> musicFiles = new ArrayList<>();
        Filewalker fw = new Filewalker(path);
        ArrayList<File> walkedFiles = fw.getFiles();
        for(File f : walkedFiles) {
            if(FileTool.getFileExtension(f).equals("MP3")) {
                musicFiles.add(new MusicFile(f));
            }
        }
        return musicFiles;
    }

    public static MusicFile getMusicFileFromFilePath(ArrayList<MusicFile> musicFiles, String filePath) {
        for(MusicFile mf : musicFiles) {
            if(mf.getFile().getAbsolutePath().equals(filePath)) {
                return mf;
            }
        }
        return null;
    }
    
    public static ArrayList<MusicFile> filterByTag(ArrayList<MusicFile> musicFiles, Tag t) {
        ArrayList<MusicFile> filteredList = new ArrayList<>();
        for(MusicFile mf : musicFiles) {
            if(mf.getTags().contains(t)) {
                filteredList.add(mf);
            }
        }
        return filteredList;
    }
}
