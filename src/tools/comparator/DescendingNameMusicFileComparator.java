package tools.comparator;

import java.util.Comparator;
import model.MusicFile;

public class DescendingNameMusicFileComparator implements Comparator<MusicFile> {

    @Override
    public int compare(MusicFile o1, MusicFile o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
