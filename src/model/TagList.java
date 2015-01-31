package model;

import java.util.HashMap;
import java.util.Map;

public class TagList {
    private final static TagList INSTANCE = new TagList();
    private final Map<String, Tag> tagMap;
    
    private TagList() {
        tagMap = new HashMap<>();
    }
    
    /**
     * Add a tag to the list
     * @param tagName the tag to add
     * @return true if the tag was actually added, false if it already exists
     */
    public static Tag addTag(String tagName) {
        if(!INSTANCE.tagMap.containsKey(tagName)) {
            Tag tag = new Tag(tagName);
            INSTANCE.tagMap.put(tagName, tag);
            return tag;
        }
        return INSTANCE.tagMap.get(tagName);
    }
}
