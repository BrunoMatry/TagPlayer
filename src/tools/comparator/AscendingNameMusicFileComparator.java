package tools.comparator;

import java.util.Comparator;
import model.MusicFile;

public class AscendingNameMusicFileComparator implements Comparator<MusicFile> {

    @Override
    public int compare(MusicFile o1, MusicFile o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
