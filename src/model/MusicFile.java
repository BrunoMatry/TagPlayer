package model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.media.Media;
import tools.FileTool;

public class MusicFile {

    private final File file;
    private Media media;
    private final List<Tag> tags;
    
    public MusicFile(File f) {
        file = f;
        media = null;
        tags = new ArrayList<>();
    }
    
    public File getFile() {
        return file;
    }
    
    public Media getMedia() {
        if(media == null) {
            media = new Media(file.toURI().toString());
        }
        return media;
    }

    public List<Tag> getTags() {
        return tags;
    }
    
    public void removeTag(Tag t) {
        tags.remove(t);
    }
    
    public void addTag(String tagName) {
        // Recuperation eventuelle du tag existant
        tags.add(TagList.addTag(tagName));
    }

    public String getName() {
        return FileTool.removeFileExtension(this.getFile().getName());
    }
}
