package tools.database;

import controller.ApplicationParameters;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Log;
import model.MusicFile;
import model.MusicFileList;

public class MyFileReader {

    public static void loadInDba(MusicFileList musicFileList) {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("database.pdb"))) {
                String fileLine;
                while ((fileLine = br.readLine()) != null) {
                    String[] elements = fileLine.split(ApplicationParameters.FILE_SEPARATOR);
                    MusicFile mf = musicFileList.getMusicFileFromFilePath(elements[0]);
                    if(mf != null) {
                        for(int i = 1 ; i < elements.length ; i++) {
                            mf.addTag(elements[i]);
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            Log.onInternalErrorLog(ex.getMessage());
        } catch (IOException ex) {
            Log.onInternalErrorLog(ex.getMessage());
        }
    }
}
