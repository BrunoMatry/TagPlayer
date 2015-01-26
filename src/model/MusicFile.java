package model;

import java.util.ArrayList;
import java.util.List;

public class MusicFile {
    private final List<Tag> tags;
    
    public MusicFile() {
        tags = new ArrayList<>();
    }
    
    public List<Tag> getTags() {
        return tags;
    }
    
    public void removeTag(Tag t) {
        tags.remove(t);
    }
    
    public void addTag(Tag t) {
        tags.add(t);
    }
}
