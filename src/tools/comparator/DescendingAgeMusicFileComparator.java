package tools.comparator;

import java.util.Comparator;
import model.MusicFile;

public class DescendingAgeMusicFileComparator implements Comparator<MusicFile> {

    @Override
    public int compare(MusicFile o1, MusicFile o2) {
        Long musicFile1LastModification = o1.getFile().lastModified();
        Long musicFile2LastModification = o2.getFile().lastModified();
        return musicFile1LastModification.compareTo(musicFile2LastModification);
    }
}
